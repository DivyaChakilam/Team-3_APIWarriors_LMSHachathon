package api.Utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public static List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        List<Map<String, String>> data = new ArrayList<>();
        Row headerRow = sheet.getRow(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) {
            Row currentRow = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();

            for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                String header = headerRow.getCell(j).getStringCellValue();
                Cell cell = currentRow.getCell(j);

                if (cell != null) {
                    rowData.put(header, cell.toString());
                } else {
                    rowData.put(header, ""); // Handle empty cells
                }
            }

            data.add(rowData);
        }

        workbook.close();
        fis.close();
        return data;
    }
}
