package api.payload;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Utility.CommonUtils;
import api.pojo.ClassPojo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ClassPayload extends CommonUtils {
	
	
	

	 public List<Map<String, String>> excelData;
	    private Map<String, String> currentRow;
	    private final Logger LOGGER = LogManager.getLogger(ClassPayload.class);
	    String sheetName = "Class"; // Updated sheet name
	    
	 // Utility method to handle empty or invalid floats
	    private float parseFloatSafely(String value) {
	        try {
	            if (value != null && !value.trim().isEmpty()) {
	                return Float.parseFloat(value);
	            } else {
	                return 0.0f; // Default to 0.0f if the value is empty or invalid
	            }
	        } catch (NumberFormatException e) {
	            LOGGER.error("Invalid float value: " + value);
	            return 0.0f; // Default to 0.0f in case of error
	        }
	    }
	    
	 

	 public Map<String, Object> getDataFromExcel(String scenario) 
	            throws IOException, ParseException, InvalidFormatException {
	     //Fetch the current row of data based on the scenario
	       currentRow = CommonUtils.getCurrentRow(scenario, sheetName);
	       
	       // Create a new HashMap to hold the class details and the current row data
	       Map<String, Object> classDetailsMap = new HashMap<String, Object>();
	       String classDate = currentRow.get("classDate").replaceAll("^\"|\"$", "");

	      
	        // Construct the ClassPojo object using data from the current row
	     ClassPojo classDetails = new ClassPojo(
	    		 parseFloatSafely(currentRow.get("batchId")),   // Changed from Double.parseDouble to Float.parseFloat
	 		    currentRow.get("classComments"),
	 		   classDate,
	 		    currentRow.get("classDescription"),
	 		   parseFloatSafely(currentRow.get("classNo")),   // Changed from Double.parseDouble to Float.parseFloat
	 		    currentRow.get("classNotes"),
	 		    currentRow.get("classRecordingPath"),
	 		    currentRow.get("classStaffId"),
	 		    currentRow.get("classTopic"),
	 		    currentRow.get("classScheduledDates") != null && !currentRow.get("classScheduledDates").isEmpty() 
	 	        ? Arrays.asList(currentRow.get("classScheduledDates").split(","))
	 	        : new ArrayList<String>(), // Return an empty list if the value is null or empty
	 	       currentRow.get("classStatus")
	     );

	        LOGGER.info("Read Class details from Excel file: " + classDetails);

	        // Populate the map with class details and the current row
	        classDetailsMap.put("classDetails", classDetails);
	        classDetailsMap.put("currentRow", currentRow);
	        return classDetailsMap;
	    }



} 