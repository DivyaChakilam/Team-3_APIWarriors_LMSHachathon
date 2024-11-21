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

import java.io.FileWriter;
import api.Utility.ExcelReader;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;



public class LoginSteps {
	
	private List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	
    private RequestSpecification requestSpec;
    private Response response;
   
	@Given("Admin creates request with required credentials for scenario")
	public void admin_creates_request_with_required_credentials_for_scenario() throws IOException {
		
    }

        
	

	@When("Admin calls API")
	public void admin_calls_api() {
		
		 
	}

	@Then("Admin validates the response")
	public void admin_validates_the_response() {
	
        }
    

    


}
