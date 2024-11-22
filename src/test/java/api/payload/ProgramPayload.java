package api.payload;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.Utility.ExcelReader;
import api.pojo.ProgramPojo;

public class ProgramPayload extends CommonUtils{
	public List<Map<String, String>> excelData;
	private Map<String, String> currentRow;
	private  final Logger LOGGER = LogManager.getLogger(ProgramPayload.class);
	String sheetName="Program";

	public Map<String, Object> getDataFromExcel(String scenario) 
			throws IOException, ParseException, InvalidFormatException {
		currentRow = CommonUtils.getCurrentRow(scenario,sheetName);
		Map<String, Object> programDetails = new  HashMap<String, Object>();
		ProgramPojo program = new ProgramPojo(currentRow.get("ProgramName"),currentRow.get("ProgramDesc"),currentRow.get("ProgramStatus"));
		LOGGER.info("Read Program details from Excel file: " + program);
		programDetails.put("program", program);
		programDetails.put("currentRow", currentRow);
		return programDetails;

	}
}
