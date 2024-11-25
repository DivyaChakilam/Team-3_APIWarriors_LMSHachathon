package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.commons.Commons;
import api.payload.ProgramPayload;
import api.pojo.ProgramPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramRequests extends CommonUtils {
	private Response response;
	private static Map<String, String> currentRow;
	private ProgramPojo programPojo;
	private static final String INVALID_PROGRAM_ID = "iuh";
    private static final int INVALID_PROGRAM_NAME = 123;
    private static final String INVALID_TOKEN = "njbsjkbfk";

	public RequestSpecification setAuth() {
		RestAssured.baseURI = endpoints.getString("baseUrl");
		return given()
				.header("Authorization", "Bearer " + TokenManager.getToken());
	}

	public  void createProgram(String scenario) 
			throws IOException, InvalidFormatException, ParseException {

		Map<String, Object> programDetails = new ProgramPayload().getDataFromExcel(scenario);
		if(programDetails != null) {
			if(programDetails.get("program") != null) {
				this.programPojo = (ProgramPojo) programDetails.get("programPojo");
			}
			if(programDetails.get("currentRow") != null) {
				this.currentRow =  (Map<String, String>) programDetails.get("currentRow");
			}
		}
	}

	public RequestSpecification buildRequest(RequestSpecification requestSpec) {
		if (requestSpec == null) {
			throw new IllegalStateException("RequestSpecification is not initialized.");
		}
		String scenarioName = currentRow.get("ScenarioName");
		if(scenarioName.contains("NoAuth")) {
			requestSpec = given();
		}
		else if(scenarioName.contains("InvalidToken")) {
			requestSpec = given()
					.header("Authorization", "Bearer " + INVALID_TOKEN);
		}
		// Set content type from currentRow
		requestSpec.contentType(currentRow.get("ContentType"));
		// Conditionally add the request body
		if (!scenarioName.equalsIgnoreCase("PutWithoutRequestBodyByID")
				//&& currentRow.get("Method").equalsIgnoreCase("GET")
				//&& currentRow.get("Method").equalsIgnoreCase("DELETE")
				) 
		{
			requestSpec.body(programPojo);
		}
		return requestSpec;
	}

	public Response sendRequest(RequestSpecification requestSpec) {
		String endpoint = currentRow.get("EndPoint");
		response = CommonUtils.getResponse(requestSpec,endpoint);
		return response;
	}

	public int getStatusCode() {
		String expectedStatusCodeString = currentRow.get("StatusCode");
		int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
		return expectedStatusCode;
	}

	public String getStatusText() {
		String scenarioName = currentRow.get("ScenarioName");
		if(!scenarioName.equalsIgnoreCase("Invalid Endpoint")&&
				(!scenarioName.equalsIgnoreCase("Mandatory"))
				&&(!scenarioName.equalsIgnoreCase("Full Details")))
		{
			String expectedStatusText = currentRow.get("StatusText");
			return expectedStatusText;
		}
		else
		{
			return null;
		}
	}

	public void saveResponseBody(Response response) {
		int programId = response.jsonPath().getInt("programId");
		Commons.setProgramId(programId);
		String programName = response.jsonPath().getString("programName");
		Commons.setProgramName(programName);
		//JSONschema response is same for both post and put requests
		String schemaPath = endpoints.getString("createProgramSchemaPath");
		CommonUtils.validateResponseSchema(response,schemaPath);
	}

	public Response sendPutRequest(RequestSpecification requestSpec,String putEndpoint) {

		String endpoint = currentRow.get("EndPoint");

		// Determine if the endpoint needs an ID or Name 
		if (putEndpoint.contains("Id")) {
			endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
					? INVALID_PROGRAM_ID
							: Commons.getProgramId();
		} else if (putEndpoint.contains("Name")) {
			endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramName")
					? INVALID_PROGRAM_NAME
							: Commons.getProgramName();
		}
		response = CommonUtils.getResponse(requestSpec,endpoint);
		return response;
	}

	public void validateProgramResponseBodyDetails(Response response) {
		String actualProgramName = response.jsonPath().getString("programName");
		Assert.assertEquals(actualProgramName, currentRow.get("ProgramName"), "Program Name in response does not match!");

		String actualProgramDescription = response.jsonPath().getString("programDescription");
		System.out.println(currentRow);
		Assert.assertEquals(actualProgramDescription, currentRow.get("ProgramDesc"), "Program Description in response does not match!");

		String actualProgramStatus = response.jsonPath().getString("programStatus");
		Assert.assertEquals(actualProgramStatus, currentRow.get("ProgramStatus"), "Program Status in response does not match!");
	}
}
