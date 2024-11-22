package api.payload;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.ExcelReader;
import api.pojo.ProgramPojo;

public class ProgramPayload {
	public  List<Map<String, String>> excelData;
	private  Map<String, String> currentRow;
	private  final Logger LOGGER = LogManager.getLogger(ProgramPayload.class);

	public   Map<String, Object> getDataFromExcel(String scenario) 
			throws IOException, ParseException, InvalidFormatException {
		try {
			if (excelData == null) {
				String filePath = "src/test/resources/TestData/Team3-API Warriors Test Data.xlsx";
				excelData = ExcelReader.readExcelData(filePath, "Program");
			}

			Map<String, Object> programDetails = new  HashMap<String, Object>();
			boolean scenarioFound = false;
			// Loop through the Excel data and compare each row's scenario with the passed scenario
			for (Map<String, String> row : excelData) {
				currentRow = row;
				String excelScenario = currentRow.get("ScenarioName");
				if (excelScenario.equalsIgnoreCase(scenario)) {
					ProgramPojo program = new ProgramPojo(currentRow.get("ProgramName"),currentRow.get("ProgramDesc"),currentRow.get("ProgramStatus"));
					LOGGER.info("Read Program details from Excel file: " + program);
					programDetails.put("program", program);
					programDetails.put("currentRow", currentRow);
					return programDetails;
				}		
			}
			throw new RuntimeException("Failed to find row for test case in Excel file: " + scenario);

		} catch (IOException e) {
			LOGGER.error("Failed to read Excel file.", e);
			throw new RuntimeException("Failed to read Excel file.", e);
		}
	}
}
