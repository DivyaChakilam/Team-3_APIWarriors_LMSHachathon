package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.commons.Commons;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletebatchRequest extends CommonUtils {
	private RequestSpecification requestSpec;
	private Response response;
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	private String scenario;
	private static final String INVALID_Batch_ID = "405";
	private static final String INVALID_TOKEN = "njbsjkbfk";
	//String sheetName; 
	private static final Logger logger = LogManager.getLogger(DeletebatchRequest.class);
	
	public  Map<String, String> Deletebatch(String scenario) 
			throws IOException, InvalidFormatException, ParseException {
		String sheetName="Deletebatch";
		this.scenario=scenario;
		currentRow = CommonUtils.getCurrentRow(scenario, "Deletebatch");
        return CommonUtils.getCurrentRow(scenario, "Deletebatch");
    }

	
	

	    /**
	     * Set the authorization header for the request.
	     */
	    public RequestSpecification setAuth() {
	        RestAssured.baseURI = endpoints.getString("baseUrl");
	        return given()
	                .header("Authorization", "Bearer " + TokenManager.getToken());
	    }

	    /**
	     * Fetch the current row from the Excel sheet based on the scenario.
	     */
	    public void fetchCurrentRow(String scenario) throws IOException, InvalidFormatException, ParseException {
	        currentRow = CommonUtils.getCurrentRow(scenario, "Deletebatch");
	    }

	    /**
	     * Build the request specification.
	     */
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
			if (!scenarioName.contains("WithoutRequestBody")
		    		 && !scenarioName.contains("Get") && !scenarioName.contains("Delete") 
					) 
			{
				requestSpec.body("");
			}
			return requestSpec;
		}
	     
	    
	    public Response sendRequest(RequestSpecification requestSpec) {
			String endpoint = currentRow.get("EndPoint");
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}

	    public Response senddeleteRequest(RequestSpecification requestSpec,String deleteEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (deleteEndpoint.contains("Id")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
						? INVALID_Batch_ID
								: 8750;//Commons.getProgramId();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	    public void validateStatusCode(Response response) {
	        int expectedStatusCode = Integer.parseInt(currentRow.get("StatusCode"));
	        int actualStatusCode = response.getStatusCode();

	        if (actualStatusCode != expectedStatusCode) {
	            throw new AssertionError(
	                    "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode);
	        }
	    }

	    /**
	     * Validate the status text of the response.
	     */
	    

	            		public void validateStatusText(Response response) {
	            	        String expectedStatusText = currentRow.get("StatusText");
	            	        String actualStatusText = response.getStatusLine();

	            	        if (!actualStatusText.contains(expectedStatusText)) {
	            	            throw new AssertionError(
	            	                    "Expected status text to contain: " + expectedStatusText + ", but got: " + actualStatusText);
	            	        }
	            	    }

	            		public int getStatusCode() {
	            			String expectedStatusCodeString = currentRow.get("StatusCode");
	            			int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
	            			return expectedStatusCode;
	            		}

	            		/*public String getStatusText() {
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
	            		}*/
	            	   
	            	    
	            	}
	            	
		
	    

