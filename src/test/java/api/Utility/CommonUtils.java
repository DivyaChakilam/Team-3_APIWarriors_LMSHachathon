package api.Utility;

import java.util.ResourceBundle;

public class CommonUtils {

	public static ResourceBundle endpoints = ResourceBundle.getBundle("endpoint");

	public static String baseURI = endpoints.getString("baseUrl");
	

}
