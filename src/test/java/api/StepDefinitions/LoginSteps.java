package api.StepDefinitions;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

import api.Utility.ExcelReader;

public class LoginSteps {
	
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	
	@Given("Admin creates request with required credentials for scenario")
	public void admin_creates_request_with_required_credentials_for_scenario() throws IOException {
		if (excelData == null) {
            String filePath = "C:/path/to/Team3-API Warriors Test Data.xlsx";
            excelData = ExcelReader.readExcelData(filePath, "LoginTests");
        }

        // Iterate through Excel rows
        for (Map<String, String> row : excelData) {
            currentRow = row;
            String email = currentRow.get("EmailId");
            String password = currentRow.get("Password");

//            // Build request body
//            LoginRequest loginRequest = new LoginRequest(email, password);
//
//            // Build request specification
//            requestSpec = given()
//                    .contentType("application/json")
//                    .body(loginRequest);
        }
	}

	@When("Admin calls API")
	public void admin_calls_api() {
	   
		 
	}

	@Then("Admin validates the response")
	public void admin_validates_the_response() {
	    
	}


}
