package api.StepDefinitions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.Utility.CommonUtils;
import api.requests.ProgramRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramSteps {
	ProgramRequests programrequest = new ProgramRequests();
	private RequestSpecification requestSpec;
	private Response response;


	@Given("Admin set Authorization")
	public void admin_set_authorization() {
		requestSpec = programrequest.setAuth();
	}

	@Given("Admin creates Request for the LMS with request body {string}")
	public void admin_creates_request_for_the_lms_with_request_body(String scenario) 
			throws IOException, InvalidFormatException, ParseException {
		programrequest.createProgram(scenario);
		requestSpec = programrequest.buildRequest(requestSpec);
	}

	@When("Admin sends HTTPS Request and request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() {
		response = programrequest.sendRequest(requestSpec);
	}

	//put request with patientID/patientName
	@When("Admin sends HTTPS Request and request Body with {string} endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint(String putEndpoint) {
		response = programrequest.sendPutRequest(requestSpec,putEndpoint);
	}

	@Then("Admin receives StatusCode with statusText {string}")
	public void admin_receives_status_code_with_status_text(String scenario) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, programrequest.getStatusCode(), "Status code does not match!");
		String expectedStatusText = programrequest.getStatusText();
		CommonUtils.validateResponseMessage(expectedStatusText,actualStatusCode,scenario,response);
		if(actualStatusCode ==200 || actualStatusCode ==201)
		{
			programrequest.saveResponseBody(response);
			programrequest.validateProgramResponseBodyDetails(response);
		}
	}

	@When("Admin sends HTTPS Request with endpoint for delete program")
	public void adminSendsHTTPSRequestWithEndpointForDeleteProgram() {
		response = programrequest.sendRequest(requestSpec);
	}

	@Then("Admin receives StatusCode for program delete with statusText")
	public void adminReceivesStatusCodeForProgramDeleteWithStatusText() {
		System.out.println(response);
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");

		}
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint with valid_invalid program ID {string}")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_with_valid_invalid_program_id(String scenario) throws IOException, ParseException, InvalidFormatException {
		programrequest.createProgram(scenario);
		requestSpec = programrequest.addPathParamForDeleteRequest(requestSpec);
	}

	@Given("Admin creates GET request for the LMS API endpoint with valid_invalid program id {string}")
	public void adminCreatesGETRequestForTheLMSAPIEndpointWithValid_invalidProgramId(String scenario) throws IOException, ParseException, InvalidFormatException {
		programrequest.createProgram(scenario);
		requestSpec = programrequest.addPathParamForDeleteRequest(requestSpec);
	}

	@When("Admin sends HTTPS Request with endpoint for get program")
	public void adminSendsHTTPSRequestWithEndpointForGetProgram() {
		response = programrequest.sendRequest(requestSpec);
	}
}
