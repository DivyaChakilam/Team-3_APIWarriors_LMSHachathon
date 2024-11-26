package api.StepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.requests.*;
import api.Utility.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetallclassesR {
	ProgramRequests programrequest = new ProgramRequests();
	GetallclassRequest classgetallrequest = new GetallclassRequest();
//GetallclassRequest getallclassrequest= new GetallclassRequest();
	private RequestSpecification requestSpec;
    private Response response;
   
//String scenario;
	@Given("Admin set Authorization")
	public void admin_set_authorization() {
		requestSpec =  classgetallrequest.setAuth();
	}

	@Given("Admin creates get request \\(all class recordings)Request for  the LMS API with  {string}")
	public void admin_creates_get_request_all_class_recordings_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		
		 classgetallrequest.getallclassrequest(scenario);
        		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	}

	@When("Admin sends   get request \\(all class recordings)HTTPS Request with endpoint")
	public void  admin_sends_get_request_all_class_recordings_https_request_with_endpoint() {
		
		response =  classgetallrequest.sendRequest(requestSpec);
		
		
        
	}

	@Then("Admin receives StatusCode with statusText for getallclassrecordings {string}")
	public void admin_receives_status_code_with_status_text_for_getallclassrecordings(String scenario)  {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(), "Status code does not match!");}
	
	
	@Given("Admin creates get request \\(all classlist)Request for  the LMS API with  {string}")
	public void admin_creates_get_request_all_classlist_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		
		 classgetallrequest.getallclassrequest(scenario);
        		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	}

	@When("Admin sends   get request \\(all class list)HTTPS Request with endpoint")
	public void admin_sends_get_request_all_class_list_https_request_with_endpoint() {
		response =  classgetallrequest.sendRequest(requestSpec);
	}

	@Then("Admin receives StatusCode with statusText for getallclasslist {string}")
	public void admin_receives_status_code_with_status_text_for_getallclasslist(String scenario) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");}
	
	@Given("Admin creates get request \\(all Classes  with valid Batchid) Request for  the LMS API with  {string}")
	public void admin_creates_get_request_all_classes_with_valid_batchid_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		classgetallrequest.getallclassrequest(scenario);
		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	}

	@When("Admin sends   get all Classes  HTTPS Request with {string} endpoint")
	public void admin_sends_get_all_classes_https_request_with_endpoint(String batchIdEndpoint) {
		response =  classgetallrequest.ClassbatchIdRequest(requestSpec,batchIdEndpoint);
		
	    
	   
	}

	@Then("Admin receives StatusCode with statusText for all Classes  with valid Batchid {string}")
	public void admin_receives_status_code_with_status_text_for_all_classes_with_valid_batchid(String scenario) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");}
	
	
	@Given("Admin creates get request \\(all Classes  with valid StaffId) Request for  the LMS API with  {string}")
	public void admin_creates_get_request_all_classes_with_valid_staff_id_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		classgetallrequest.getallclassrequest(scenario);
		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	}

	@When("Admin sends   get all Classes  with HTTPS Request with {string} endpoint")
	public void admin_sends_get_all_classes_with_https_request_with_endpoint(String StaffIdEndpoint) {
		response =  classgetallrequest.ClassstaffIdRequest(requestSpec,StaffIdEndpoint);
		
	}

	@Then("Admin receives StatusCode with statusText for all Classes  with StaffId {string}")
	public void admin_receives_status_code_with_status_text_for_all_classes_with_staff_id(String string) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");
	}

	@Given("Admin creates get request \\(all Classes  with valid ClassTopic) Request for  the LMS API with  {string}")
	public void admin_creates_get_request_all_classes_with_valid_class_topic_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		classgetallrequest.getallclassrequest(scenario);
		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	    
	}

	@When("Admin sends get all class HTTPS Request with {string} endpoint")
	public void admin_sends_get_all_class_https_request_with_endpoint(String ClassTopicEndpoint) {
		response =  classgetallrequest.ClassTopicRequest(requestSpec,ClassTopicEndpoint);
	    	}
		
	    
	    
	
	@Then("Admin receives StatusCode with statusText for all Classes  with ClassTopic {string}")
	public void admin_receives_status_code_with_status_text_for_all_classes_with_class_topic(String string) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");
	}

	@Given("Admin creates get request to retrieve upcoming classes Request for  the LMS API with  {string}")
	public void admin_creates_get_request_to_retrieve_upcoming_classes_request_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		classgetallrequest.getallclassrequest(scenario);
		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	    
	}

	@When("Admin sends   get request to retrieve upcoming classes  with {string} endpoint")
	public void admin_sends_get_request_to_retrieve_upcoming_classes_with_endpoint(String studentIdEndpoint) {
		response =  classgetallrequest.StudentidRequest(requestSpec,studentIdEndpoint);
	
	}
		
	    

	@Then("Admin receives StatusCode with statusText  for retrieve upcoming classesforparticularstudentId {string}")
	public void admin_receives_status_code_with_status_text_for_retrieve_upcoming_classesforparticularstudent_id(String scenario) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");
	}

	@Given("Admin creates get request to downloadClassRecordingsbyClassId for  the LMS API with  {string}")
	public void admin_creates_get_request_to_download_class_recordingsby_class_id_for_the_lms_api_with(String scenario) throws IOException, InvalidFormatException, ParseException {
		classgetallrequest.getallclassrequest(scenario);
		requestSpec =  classgetallrequest.buildRequest(requestSpec);
	    
	}

	@When("Admin sends   get request to downloadClassRecordingsbyClassId  with {string} endpoint")
	public void admin_sends_get_request_to_download_class_recordingsby_class_id_with_endpoint(String ClassIdEndpoint) {
		response =  classgetallrequest.ClassidRequest(requestSpec,ClassIdEndpoint);
	
	}
		
	    
	   

	@Then("Admin receives StatusCode with statusText  for downloadClassRecordingsbyClassId {string}")
	public void admin_receives_status_code_with_status_text_for_download_class_recordingsby_class_id(String scenario) {
		if (response == null) {
			throw new AssertionError("Response is null. API call might have failed.");
		}
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,  classgetallrequest.getStatusCode(),"Status code does not match!");
	}}


	

