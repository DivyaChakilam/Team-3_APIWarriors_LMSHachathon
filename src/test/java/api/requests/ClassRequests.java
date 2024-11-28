package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.commons.Commons;
import api.payload.ClassPayload;
import api.payload.UpdateClassRecPayload;
import api.pojo.ClassPojo;
import api.pojo.UpdateClassRecPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClassRequests extends CommonUtils {
    private RequestSpecification requestSpec;
    private Response response;
    private List<Map<String, String>> excelData;
    private Map<String, String> currentRow;
    private ClassPojo classPojo;
    private UpdateClassRecPojo updateClassRecPojo;
    private static final String INVALID_TOKEN = "njbsj768798hghgkbfk";

    // Method to set Authorization
    public RequestSpecification setAuth() {
        RestAssured.baseURI = endpoints.getString("baseUrl"); // Base URL from properties file
        return given()
                .header("Authorization", "Bearer " + TokenManager.getToken()); // Adds Authorization header
    }

    // Method to create Class Request from Excel data
    public void createClassRequest(String scenario) 
            throws IOException, InvalidFormatException, ParseException {
        // Get data from Excel based on the scenario
        Map<String, Object> classDetails = new ClassPayload().getDataFromExcel(scenario);

        if (classDetails != null) {
            if (classDetails.get("classDetails") != null) {
                this.classPojo = (ClassPojo) classDetails.get("classDetails"); // Map POJO data
            }
            if (classDetails.get("currentRow") != null) {
                this.currentRow = (Map<String, String>) classDetails.get("currentRow"); // Map Excel row data
            }
        } else {
            throw new IllegalArgumentException("Class details are null. Ensure Excel data is correctly formatted.");
        }
    }


    // Method to build the RequestSpecification with content type and body
    public RequestSpecification buildRequest(RequestSpecification requestSpec) {
        if (requestSpec == null) {
            throw new IllegalStateException("RequestSpecification is not initialized.");
        }

        // Ensure content type and body are valid
        String contentType = currentRow != null && currentRow.get("ContentType") != null 
                ? currentRow.get("ContentType") 
                : "application/json"; // Default to application/json if not provided

        if (classPojo == null) {
            throw new IllegalArgumentException("ClassPojo object is null. Cannot construct request body.");
        }

        return requestSpec
                .contentType(contentType)
                .body(classPojo); // Attach the body from the POJO
    }
    
    // Method to send the request and get the response
    public Response sendRequest(RequestSpecification requestSpec) {

    	String endpoint = currentRow.get("EndPoint");
		response = CommonUtils.getResponse(requestSpec,endpoint);
    	
		return response;

    }
    
    //================================PUT REQUEST METHODS=======================================
    
// // Method to create Class Request from Excel data
    public void createUpdateClassRecRequest(String scenario) 
            throws IOException, InvalidFormatException, ParseException {
        // Get data from Excel based on the scenario
//    	System.out.println("Preparing Class Recording Details...");
//        Map<String, Object> classUpdateDetails = new UpdateClassRecPayload().getDataFromExcel(scenario);
//         System.out.println("classDetails are: "+classUpdateDetails);
//        if (classUpdateDetails != null) {
//            if (classUpdateDetails.get("classRecDetails") != null) {
//                this.classRecDetails = (UpdateClassRecPojo) classUpdateDetails.get("classRecDetails"); // Map POJO data
//               System.out.println("classRecPojo is"+ classRecDetails);
//                }
//            if (classUpdateDetails.get("currentRow") != null) {
//                this.currentRow = (Map<String, String>) classUpdateDetails.get("currentRow"); // Map Excel row data
//            }
//        } else {
//            throw new IllegalArgumentException("Class details are null. Ensure Excel data is correctly formatted.");
//        }
    	
    	Map<String, Object> classRecUpdateMap = new UpdateClassRecPayload().getDataFromExcel(scenario);
		if(classRecUpdateMap != null) {
			if(classRecUpdateMap.get("updateClassRecPojo") != null) {
				this.updateClassRecPojo = (UpdateClassRecPojo) classRecUpdateMap.get("updateClassRecPojo");
			}
			if(classRecUpdateMap.get("currentRow") != null) {
				this.currentRow =  (Map<String, String>) classRecUpdateMap.get("currentRow");
			}
		}

    }
    
    // Method to build the RequestSpecification with content type and body
    public RequestSpecification buildPutRequest(RequestSpecification requestSpec) {
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
		else if(scenarioName.contains("InvalidBaseURI")) {
			RestAssured.baseURI = endpoints.getString("invalidBaseUrl");
			return given()
					.header("Authorization", "Bearer " + TokenManager.getToken());
		}

		// Set content type from currentRow
		requestSpec.contentType(currentRow.get("ContentType"));
		// Conditionally add the request body
		if (!scenarioName.contains("WithoutRequestBody")
				&& !scenarioName.contains("GET")
				&& !scenarioName.contains("Delete")
				) 
		{
			requestSpec.body(classPojo);
		}
		
		return requestSpec;
    }
    
    
    //----------Method for Sending Put Request-----------------
      public Response sendPutRequest(RequestSpecification requestSpec) {
    	String ClassId = currentRow.get("classId");
    	String endpoint = currentRow.get("EndPoint");

		// Construct Endpoint with Valid or Invalid Id
		if (ClassId.contains("Valid")) {
			endpoint += Commons.getClassId();
			} 
		
		response = CommonUtils.getResponse(requestSpec,endpoint);
		return response;
	  }
      
      //--------------------Method to Validate Schema-----------------
      public void validateClassSchema(Response response) {
    	String schemaPath = endpoints.getString("createClassSchemaPath");
  		CommonUtils.validateResponseSchema(response,schemaPath);
  	  }      
      
   // Method to create Class Request from Excel data
      public void createClassUpdateRequest(String scenario) 
              throws IOException, InvalidFormatException, ParseException {
          // Get data from Excel based on the scenario
          Map<String, Object> classDetails = new ClassPayload().getDataFromExcel(scenario);

          if (classDetails != null) {
              if (classDetails.get("classDetails") != null) {
                  this.classPojo = (ClassPojo) classDetails.get("classDetails"); // Map POJO data
              }
              if (classDetails.get("currentRow") != null) {
                  this.currentRow = (Map<String, String>) classDetails.get("currentRow"); // Map Excel row data
              }
          } else {
              throw new IllegalArgumentException("Class details are null. Ensure Excel data is correctly formatted.");
          }
      }

      
    
}