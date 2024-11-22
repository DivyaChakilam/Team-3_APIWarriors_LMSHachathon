package api.requests;

import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.Utility.CommonUtils;
import api.payload.LoginPayload;
import api.pojo.LoginPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class LoginRequests extends CommonUtils {
	 private static final Logger logger = LogManager.getLogger(LoginRequests.class);
	
    public static RequestSpecification buildRequest(Map<String, String> currentRow) {
        // Use LoginPayload class to create the payload
        LoginPayload payload = new LoginPayload(currentRow.get("EmailId"), currentRow.get("Password"));
       // Log the data for the current row
       // logger.info("Building request for EmailId: {} with Password: {}", currentRow.get("EmailId"), currentRow.get("Password"));
        // Build the request specification
		RestAssured.baseURI = endpoints.getString("baseUrl");

        return given()
                .contentType("application/json")
                .body(payload);
    }

    public static Response sendRequest(RequestSpecification requestSpec, Map<String, String> currentRow) {
        String method = currentRow.get("Method");
        String endpoint = currentRow.get("EndPoint");
        Response response;
        switch (method.toUpperCase()) {
            case "POST":
                response = requestSpec.when().post(endpoint);
                break;
            case "GET":
                response = requestSpec.when().get(endpoint);
                break;
            case "PUT":
                response = requestSpec.when().put(endpoint);
                break;
            case "DELETE":
                response = requestSpec.when().delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
       return response;
    }
	
}