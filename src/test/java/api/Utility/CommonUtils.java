package api.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonUtils {
	public static List<Map<String, String>> excelData;
	public static Map<String, String> currentRow;
	public static ResourceBundle endpoints = ResourceBundle.getBundle("endpoint");
	public static String baseURI = endpoints.getString("baseUrl");
	public static String filePath = endpoints.getString("excelPath");
	public static Map<String, String> getCurrentRow(String scenario,String sheetName){
		try {
			if (excelData == null) {
				excelData = ExcelReader.readExcelData(filePath, sheetName);
			}
			// Loop through the Excel data and compare each row's scenario with the passed scenario
			for (Map<String, String> row : excelData) {
				currentRow = row;
				String excelScenario = currentRow.get("ScenarioName");
				if (excelScenario.equalsIgnoreCase(scenario)) {
					return currentRow;
				}
			}throw new RuntimeException("Failed to find row for test case in Excel file: " + scenario);
		}catch (IOException e) {
			//LOGGER.error("Failed to read Excel file.", e);
			throw new RuntimeException("Failed to read Excel file.", e);
		}
	}
	public static Response getResponse(RequestSpecification requestSpec) {
		if (requestSpec == null || currentRow == null) {
            throw new IllegalStateException("Request or currentRow is not initialized.");
        }

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

