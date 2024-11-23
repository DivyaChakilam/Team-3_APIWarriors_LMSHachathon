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
		// Load the Excel data if not already loaded
		this.scenario = scenario;
		if (excelData == null) {
			String filePath = "src/test/resources/TestData/Team3-API Warriors Test Data.xlsx";
			excelData = ExcelReader.readExcelData(filePath, "Login");
		}
		boolean scenarioFound = false;
		// Loop through the Excel data and compare each row's scenario with the passed scenario
		for (Map<String, String> row : excelData) {
			currentRow = row;
			String excelScenario = currentRow.get("ScenarioName");
			if (excelScenario.equalsIgnoreCase(scenario)) {
				scenarioFound = true;
				// Build the request using the data from the current row
				requestSpec = LoginRequests.buildRequest(currentRow);
				break;
			}
		}
		if (!scenarioFound) {
			throw new IOException("Scenario not found in the Excel data: " + scenario);
		}
	}

	@When("Admin calls post method with endpoint")
	public void admin_calls_post_method_with_endpoint() {
		if (requestSpec == null) {
			throw new NullPointerException("Request Specification is null. Please check if the scenario was found in Excel.");
		}
		// Send the request using the built request specification
		response = LoginRequests.sendRequest(requestSpec, currentRow);
	}

	@Then("Admin receives status code with status text")
	public void admin_receives_status_code_with_status_text() {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		String expectedStatusCodeString = currentRow.get("StatusCode");
		String expectedStatusText = currentRow.get("StatusText");
		int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
		int actualStatusCode = response.getStatusCode();
		//		String actualStatusText =response.getStatusLine();
		//		System.out.println("actualStatusText :" + actualStatusText);
		String actualStatusMessage;
		if(actualStatusCode == 200)
		{
			String token = response.jsonPath().getString("token");
			if (token != null && !token.isEmpty()) {
				TokenManager.setToken(token);
				System.out.println("Token saved successfully: " + token);
				String token1 = TokenManager.getToken();
				System.out.println("saved Token: " + token1);

			} else {
				Assert.fail("Token is null or empty. Cannot save the token.");
			}
		}
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code does not match!");
		if(actualStatusCode != 200 &&  !scenario.equalsIgnoreCase("Invalid Endpoint")) {
			actualStatusMessage = response.jsonPath().getString("message");
			Assert.assertEquals(actualStatusMessage, expectedStatusText, "Status Text does not match!");
		}
	}

}
