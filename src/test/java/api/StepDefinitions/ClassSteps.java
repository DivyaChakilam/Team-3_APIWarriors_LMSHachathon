package api.StepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.requests.ClassRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ClassSteps {

    ClassRequests classRequests = new ClassRequests(); // Assuming ClassRequests class handles the API calls
    private RequestSpecification requestSpec;
    private Response response;
    private String scenario;
    private Map<String, String> currentRow;
	 

    @Given("Admin set Class Authorization")
    public void admin_set_class_authorization() {
        requestSpec = classRequests.setAuth(); // Set the Authorization token
    }

    @Given("Admin creates Class Request for the LMS with request body {string}")
    public void admin_creates_class_request_for_the_lms_with_request_body(String scenario) 
            throws IOException, InvalidFormatException, ParseException {
        classRequests.createClassRequest(scenario); // Prepare the request body based on the scenario
        requestSpec = classRequests.buildRequest(requestSpec); // Attach the request body to the specification
    }

    @When("Admin sends HTTPS Class Request and request Body with endpoint")
    public void admin_sends_https_class_request_and_request_body_with_endpoint() {
        response = classRequests.sendRequest(requestSpec); // Send the HTTPS request to the endpoint
    }

    @Then("Admin receives StatusCode with statusText in class module")
    public void admin_receives_status_code_with_status_text_in_class_module() {
        if (response == null) {
            throw new AssertionError("Response is null. API call might have failed.");
        }
        
    }
    
    //-----------------------------CLASS PUT ----------------------------------------
    @Given("Admin creates Class Put Request for the LMS with request body {string}")
    public void admin_creates_class_put_request_for_the_lms_with_request_body(String scenario)
    		 throws IOException, InvalidFormatException, ParseException {
    	currentRow = CommonUtils.getCurrentRow(scenario, "ClassRecUpdate");
    	classRequests.createUpdateClassRecRequest(scenario); 
        requestSpec = classRequests.buildPutRequest(requestSpec); 
   }
    
    @When("Admin sends HTTPS Request and request Body with put by ClassId endpoint")
    public void admin_sends_https_request_and_request_body_with_put_by_class_id_endpoint() {
    	response = classRequests.sendPutRequest(requestSpec);
    }
    
    @Then("Admin receives StatusCode with statusText for the Put Class request sent")
    public void admin_receives_status_code_with_status_text_for_the_put_class_request_sent() {
    	if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
    	//---------------Validate Status Code-----------------
    	int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, Integer.parseInt(currentRow.get("StatusCode")), "Status code does not match!");
			
		
		if(currentRow.get("StatusCode").equalsIgnoreCase("200")) {
			//-------------------Validate Updated Rec Path Details-----------------------
			String actualRecPathInResponse = response.jsonPath().getString("classRecordingPath");
			Assert.assertEquals(actualRecPathInResponse, currentRow.get("classRecordingPath"), "Recording Path is Not Updated!");
			
			//-------------Validate Schema-----------------------------
			classRequests.validateClassSchema(response);
			}		
	}
    
    @Given("Admin creates Class Update All details Request for the LMS with request body {string}")
    public void admin_creates_class_update_all_details_request_for_the_lms_with_request_body(String scenario) 
    		throws IOException, InvalidFormatException, ParseException{
    	currentRow = CommonUtils.getCurrentRow(scenario, "Class");
    	classRequests.createClassUpdateRequest(scenario); 
        requestSpec = classRequests.buildPutRequest(requestSpec); 
    }
    
    @Then("Admin receives StatusCode with statusText for the Put Class Details request sent")
    public void admin_receives_status_code_with_status_text_for_the_put_class_details_request_sent() {
    	if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
    	//---------------Validate Status Code-----------------
    	float actualStatusCode = Float.parseFloat(String.valueOf(response.getStatusCode()));
    	System.out.println("Actual Response status Code: "+actualStatusCode);
    	System.out.println("Expected status: "+currentRow.get("StatusCode"));
		Assert.assertEquals(actualStatusCode, currentRow.get("StatusCode"), "Status code does not match!");
				
    }
  
   

    
}
