package api.Utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

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
}

