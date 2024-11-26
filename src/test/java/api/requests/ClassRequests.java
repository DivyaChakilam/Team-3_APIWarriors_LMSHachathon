package api.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.payload.ClassPayload;
import api.pojo.ClassPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClassRequests extends CommonUtils {
    private RequestSpecification requestSpec;
    private Response response;
    private List<Map<String, String>> excelData;
    private Map<String, String> currentRow;
    private ClassPojo classPojo;

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
}
