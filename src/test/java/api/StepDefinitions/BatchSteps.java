package api.StepDefinitions;

import api.requests.BatchRequests;
import api.requests.ProgramRequests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import java.io.IOException;
import java.io.InvalidClassException;
import java.text.ParseException;

public class BatchSteps {
    BatchRequests batchrequest = new BatchRequests();
    private RequestSpecification requestSpec;
    private Response response;

    @Given("Admin set Authorization for batch")
    public void admin_set_authorization_for_batch() {
        requestSpec = batchrequest.setAuth();


    }

    @Given("Admin creates POST Request  with valid data in requestBody for {string}")
    public void admin_creates_post_request_with_valid_data_in_request_body_for(String scenario)
            throws IOException, InvalidClassException, ParseException, InvalidFormatException {
        batchrequest.createBatch(scenario);
        requestSpec = batchrequest.buildRequest(requestSpec);

    }

    @When("Admin sends HTTPS Request with endpoint")
    public void admin_sends_https_request_with_endpoint() {
        response = batchrequest.sendRequest(requestSpec);
    }

    @Then("Admin receives StatusCode for batch with statusText")
    public void admin_receives_status_code_for_batch_with_status_text() {
        System.out.println(response);
        if (response == null) {
            throw new AssertionError("Response is null. API call might have failed.");

        }}
    @Given("Admin creates PUT Request  with valid data in requestBody for {string}")
    public void admin_creates_put_request_with_valid_data_in_request_body_for(String scenario)
            throws IOException, ParseException, InvalidFormatException {
        batchrequest.createBatch(scenario);
        requestSpec = batchrequest.buildRequest(requestSpec);

    }

    @Given("Admin creates GET Request with valid\\/invalid Program Id for {string}")
    public void admin_creates_get_request_with_valid_invalid_program_id_for(String scenario)
            throws IOException, ParseException, InvalidFormatException {
       batchrequest.createBatch(scenario);

    }

    @Given("Admin set Authorization for batch delete")
    public void admin_set_authorization_for_batch_delete() {
        requestSpec = batchrequest.setAuth();
    }

    @Given("Admin creates delete a Batch Request for the LMS with request body {string}")
    public void admin_creates_delete_a_batch_request_for_the_lms_with_request_body(String scenario) throws IOException, InvalidFormatException, ParseException {
        batchrequest.createBatch(scenario);
        requestSpec = batchrequest.buildRequest(requestSpec);

    }

    @When("Admin sends HTTPS delete a Batch Request and request Body with {string} endpoint")
    public void admin_sends_https_delete_a_batch_request_and_request_body_with_endpoint(String deleteEndpoint) {
        response = batchrequest.senddeleteRequest(requestSpec,deleteEndpoint);
    }

    @Then("Admin receives StatusCode with statusText for delete a Batch {string}")
    public void admin_receives_status_code_with_status_text_for_delete_a_batch(String scenario) {
        if (response == null) {
            throw new AssertionError("Response is null. API call might have failed.");
        }
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, batchrequest.getStatusCode(), "Status code does not match!");
    }
}
