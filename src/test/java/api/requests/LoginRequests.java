package api.requests;

import java.util.ResourceBundle;

import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class LoginRequests {
	
	//------------To collect data from Routes.properties file-----------------
		 static ResourceBundle getURL(){
			ResourceBundle resRoute = ResourceBundle.getBundle("endpoint");
			return resRoute;
		 //}
		
		 //-------------To Create a User---------------
//		public static Response createUser(String Endpoint,String emailid, String password, String ContentType, User payload){		
//			String post_url = getURL().getString("post_url");
//			Response response = 
//					given()
//					   .pathParam("loginEndpoint",Endpoint)
//					   .contentType(ContentType)
//					   .accept("application/json")	
//					   .body(payload);

			//return response;
}
}
