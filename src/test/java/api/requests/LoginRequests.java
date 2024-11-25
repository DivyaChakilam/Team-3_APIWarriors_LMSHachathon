package api.requests;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.Utility.CommonUtils;
import api.payload.LoginPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRequests extends CommonUtils {

	 private static final Logger logger = LogManager.getLogger(LoginRequests.class);
	 private static Response response;
	
    public static RequestSpecification buildRequest(Map<String, String> currentRow) {
        // Use LoginPayload class to create the payload
        LoginPayload payload = new LoginPayload(currentRow.get("EmailId"), currentRow.get("Password"));
		RestAssured.baseURI = endpoints.getString("baseUrl");
        return given()
                .contentType(currentRow.get("ContentType"))
                .body(payload);
    }

    public static Response sendRequest(RequestSpecification requestSpec, Map<String, String> currentRow) {
    	String endpoint = currentRow.get("EndPoint");
    	response = CommonUtils.getResponse(requestSpec,endpoint);
		return response;
    }
	

}