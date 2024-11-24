package api.payload;

import api.Utility.CommonUtils;
import api.pojo.BatchPojo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchPayload extends CommonUtils {
    public List<Map<String, String>> excelData;
    private Map<String, String> currentRow;
    private final Logger LOGGER = LogManager.getLogger(BatchPayload.class);
    String sheetName="Batch";

    public Map<String, Object> getDataFromExcel(String scenario)
            throws IOException, ParseException, InvalidFormatException {
        currentRow = CommonUtils.getCurrentRow(scenario,sheetName);
        Map<String, Object> batchDetails = new HashMap<String, Object>();
        BatchPojo batch = new BatchPojo(currentRow.get("batchDescription"),currentRow.get("batchName"),currentRow.get("batchStatus"));
        LOGGER.info("Read batch details from Excel file: " + batch);
        batchDetails.put("batch", batch);
        batchDetails.put("currentRow", currentRow);
        return batchDetails;

    }
}
