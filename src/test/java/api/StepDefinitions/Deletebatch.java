package api.StepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.Utility.CommonUtils;
import api.requests.DeletebatchRequest;
import api.requests.ProgramRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deletebatch extends  CommonUtils{
	ProgramRequests programrequest = new ProgramRequests();
	DeletebatchRequest deleterequest = new DeletebatchRequest();
	private RequestSpecification requestSpec;
    private Response response;
    private List<Map<String, String>> excelData;
    private Map<String, String> currentRow;
String scenario;
@Given("Admin set Authorization for batch delete")
public void admin_set_authorization_for_batch_delete() {
	requestSpec = programrequest.setAuth();
}

@Given("Admin creates delete a Batch Request for the LMS with request body {string}")
public void admin_creates_delete_a_batch_request_for_the_lms_with_request_body(String scenario) throws IOException, InvalidFormatException, ParseException {
	deleterequest.Deletebatch(scenario);
	requestSpec = deleterequest.buildRequest(requestSpec);
   
}

@When("Admin sends HTTPS delete a Batch Request and request Body with {string} endpoint")
public void admin_sends_https_delete_a_batch_request_and_request_body_with_endpoint(String deleteEndpoint) {
	response = deleterequest.senddeleteRequest(requestSpec,deleteEndpoint);
}

@Then("Admin receives StatusCode with statusText for delete a Batch {string}")
public void admin_receives_status_code_with_status_text_for_delete_a_batch(String scenario) {
	if (response == null) {
		throw new AssertionError("Response is null. API call might have failed.");
	}
	int actualStatusCode = response.getStatusCode();
	Assert.assertEquals(actualStatusCode, deleterequest.getStatusCode(), "Status code does not match!");
	//String expectedStatusText = deleterequest.getStatusText();
	//CommonUtils.validateResponseMessage(expectedStatusText,actualStatusCode,scenario,response);
}

	}
	


