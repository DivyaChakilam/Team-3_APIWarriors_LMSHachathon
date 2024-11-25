package api.StepDefinitions;

import java.io.IOException;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.testng.Assert;

import api.Utility.CommonUtils;
import api.Utility.ExcelReader;
import api.Utility.TokenManager;
import api.requests.LoginRequests;

public class LoginSteps {

	private RequestSpecification requestSpec;
	private Response response;
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	String scenario;
	
	@Given("Admin creates request with credentials with {string}")
	public void admin_creates_request_with_credentials_with(String scenario) throws IOException {
				this.scenario = scenario;
				String sheetName = "Login";
				currentRow = CommonUtils.getCurrentRow(scenario,sheetName);
				requestSpec = LoginRequests.buildRequest(currentRow);
	}

	@When("Admin calls post method with endpoint")
	public void admin_calls_post_method_with_endpoint() {
		if (requestSpec == null) {
			throw new NullPointerException("Request Specification is null. Please check if the scenario was found in Excel.");
		}
		
    	response = LoginRequests.sendRequest(requestSpec, currentRow);
	}

	@Then("Admin receives status code with status text")
	public void admin_receives_status_code_with_status_text() {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		String expectedStatusCodeString = currentRow.get("StatusCode");
		String expectedResponseMessage = currentRow.get("ResponseMessage"); //Catch Error Message
		int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
		int actualStatusCode = response.getStatusCode();
       //---------Validate Status Code-----------------
		String actualStatusMessage;
		if(actualStatusCode == 200)
		{
			String token = response.jsonPath().getString("token");
			if (token != null && !token.isEmpty()) {
				TokenManager.setToken(token);
			} else {
				Assert.fail("Token is null or empty. Cannot save the token.");
			}
		}
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match!");
		
		//-------------------Validate Response Message Displayed-----------------------
		if(actualStatusCode != 200 &&  !scenario.equalsIgnoreCase("Invalid Endpoint")) {
			String actualResponseMessage = response.jsonPath().getString("message");
			Assert.assertEquals(actualResponseMessage, expectedResponseMessage, "Status Text does not match!");
		}
	}

}
