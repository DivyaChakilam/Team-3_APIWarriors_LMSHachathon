package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.pojo.ProgramPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetallclassRequest extends CommonUtils {
	public RequestSpecification requestSpec;
	private Response response;
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	private static final String INVALID_TOKEN = "njbsjkbfk";
	private static  String INVALID_Batch_ID="1234";
	private static  String INVALID_Staff_ID="k78";
	private static  String INVALID_Classtopic="98y";
	private static  String INVALID_Student_id="l08";
	private static  String INVALID_class_id="p09";
	private String scenario;

	
	public  Map<String, String> getallclassrequest(String scenario) 
			throws IOException, InvalidFormatException, ParseException {
		//String sheetName="Getallclassrecordings";
		this.scenario=scenario;
		currentRow = CommonUtils.getCurrentRow(scenario, "Getallclassrecordings");
        return CommonUtils.getCurrentRow(scenario, "Getallclassrecordings");
    }
	public void fetchCurrentRow(String scenario) throws IOException, InvalidFormatException, ParseException {
        currentRow = CommonUtils.getCurrentRow(scenario, "Getallclassrecordings");
    }
	 public RequestSpecification setAuth() {
	        RestAssured.baseURI = endpoints.getString("baseUrl");
	        return given()
	                .header("Authorization", "Bearer " + TokenManager.getToken());
	    }

    
	 public RequestSpecification buildRequest(RequestSpecification requestSpec)
	 { if (requestSpec == null) { {
	        // Initialize requestSpec if null
	        requestSpec = setAuth();
	    };
	 }
	 String scenarioName = currentRow.get("ScenarioName"); 
	 
	 if(scenarioName.contains("NoAuth")) { requestSpec = given(); } 
	 else if(scenarioName.contains("InvalidToken"))
	 { requestSpec = given() .header("Authorization", "Bearer " + INVALID_TOKEN); } 
	 
	 else if(scenarioName.contains("InvalidBaseURI")) 
	 { RestAssured.baseURI = endpoints.getString("invalidBaseUrl"); return given() .header("Authorization", "Bearer " + TokenManager.getToken()); } // Set content type from 
	 
	 requestSpec.contentType(currentRow.get("ContentType")); 
	 if (!scenarioName.contains("WithoutRequestBody") 
			 && ! scenarioName.contains("Get") 
			 && !scenarioName.contains("Delete") )
	 { requestSpec.body(""); }
	 
	 return requestSpec; }
	 
	 
		
	 public Response sendRequest(RequestSpecification requestSpec) {
			String endpoint = currentRow.get("EndPoint");
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 
	 public Response ClassbatchIdRequest(RequestSpecification requestSpec,String batchIdEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (batchIdEndpoint.contains("Id")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
						? INVALID_Batch_ID
								: 8641;//Commons.getbatchId();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 public Response ClassstaffIdRequest(RequestSpecification requestSpec,String StaffIdEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (StaffIdEndpoint.contains("Id")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
						? INVALID_Staff_ID
								: "U49";//Commons.getStaffId();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 
	 public Response ClassTopicRequest(RequestSpecification requestSpec,String ClassTopicEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (ClassTopicEndpoint.contains("Topic")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramName")
						? INVALID_Classtopic
								: "Java";//Commons.ClassTopic();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 public Response StudentidRequest(RequestSpecification requestSpec,String StudentidEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (StudentidEndpoint.contains("Id")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
						? INVALID_Student_id
								: "U24";//Commons.getStudentId();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 
	 public Response ClassidRequest(RequestSpecification requestSpec,String classidEndpoint) {

			String endpoint = currentRow.get("EndPoint");

			 
			if (classidEndpoint.contains("Id")) {
				endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
						? INVALID_class_id
								: "147";//Commons.getClassId();
			
			}
			response = CommonUtils.getResponse(requestSpec,endpoint);
			return response;
		}
	 public int getStatusCode() {
			String expectedStatusCodeString = currentRow.get("StatusCode");
			int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
			return expectedStatusCode;
		}
	 
	 
	 
	 
	 
	 
	 
	 
	
	   
}   

	


