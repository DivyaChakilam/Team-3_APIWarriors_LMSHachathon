package api.payload;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.commons.Commons;
import api.pojo.ClassPojo;
import api.pojo.UpdateClassRecPojo;

public class UpdateClassRecPayload extends CommonUtils {
	
	 public List<Map<String, String>> excelData;
	    private Map<String, String> currentRow;
	    private final Logger LOGGER = LogManager.getLogger(ClassPayload.class);
	    String sheetName="ClassRecUpdate"; // Updated sheet name

//	 public Map<String, Object> getDataFromExcel(String scenario) 
//	            throws IOException, ParseException, InvalidFormatException {
//	     //Fetch the current row of data based on the scenario
//	       currentRow = CommonUtils.getCurrentRow(scenario, sheetName);
//	       System.out.println("currentRow is "+ currentRow);
//	       // Create a new HashMap to hold the class details and the current row data
//	       Map<String, Object> classRecUpdateMap = new HashMap<String, Object>();
//	     	      
//	     // Construct the UpdateClassRecPojo object using data from the current row
//	       UpdateClassRecPojo classRecDetails = new UpdateClassRecPojo(
//	    		currentRow.get("classRecordingPath"),
//	    		Commons.getClassId()
//	 		  );
//
//	        LOGGER.info("Read Class details from Excel file: " + classRecUpdateMap);
//
//	        // Populate the map with class details and the current row
//	        classRecUpdateMap.put("classRecDetails", classRecDetails);
//	        classRecUpdateMap.put("currentRow", currentRow);
//	        return classRecUpdateMap;
//	    }
	    
	    public Map<String, Object> getDataFromExcel(String scenario) 
	            throws IOException, ParseException, InvalidFormatException{
	    	//Fetch the current row of data based on the scenario
	        currentRow = CommonUtils.getCurrentRow(scenario, sheetName);
	        System.out.println("currentRow is "+ currentRow);
	     // Create a new HashMap to hold the class details and the current row data
	        Map<String, Object> classRecUpdateMap = new HashMap<String, Object>();
	     // Construct the UpdateClassRecPojo object using data from the current row
	        UpdateClassRecPojo updateClassRecPojo = new UpdateClassRecPojo(
	     		currentRow.get("classRecordingPath"),
	     		Commons.getClassId()
	  		  );
	        //LOGGER.info("Read Class details from Excel file: " + classRecUpdateMap);
	        // Populate the map with class details and the current row
	        classRecUpdateMap.put("updateClassRecPojo", updateClassRecPojo);
	        classRecUpdateMap.put("currentRow", currentRow);
			return classRecUpdateMap; 

	    }

}
