package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.payload.ProgramPayload;
import api.pojo.ProgramPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramRequests extends CommonUtils {
	private RequestSpecification requestSpec;
	private Response response;
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	private ProgramPojo program;

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
				this.program = (ProgramPojo) programDetails.get("program");
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
		return requestSpec.contentType(currentRow.get("ContentType")).body(program);

	}

	public Response sendRequest(RequestSpecification requestSpec) {

		response = CommonUtils.getResponse(requestSpec);
		return response;
	}
}
