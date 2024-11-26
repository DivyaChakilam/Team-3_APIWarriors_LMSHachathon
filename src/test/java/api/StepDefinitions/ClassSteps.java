package api.StepDefinitions;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
}
