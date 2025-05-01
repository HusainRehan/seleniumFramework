package seleniumFramework.util;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExcelUtil {
	
	private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
	
	private static Map<String, Map<String, String>> sheetRows = new HashMap<>();

	public static void  loadTestTestData() throws Exception {
		logger.info("excel loading started");
		
		String rootDirectory = System.getProperty("user.dir");
		String path = rootDirectory + "/src/test/resources/TestData/testData.xlsx";
		System.out.println("File path: " + path);
		Workbook wb = WorkbookFactory.create(new FileInputStream(new String(path)));
		
		Sheet sheet = wb.getSheetAt(0);
		
		Row headerRow = sheet.getRow(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		
		
		
		for(int i = 1; i < rows; i++) {
			Map<String, String> map = new HashMap<>();
			Row row = sheet.getRow(i);
			for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
				map.put(formatData(headerRow.getCell(j)), formatData(row.getCell(j)));
			}
			logger.debug("Row " + i + "Data : " + map);
			sheetRows.put(map.get("TestCase"), map);
			
		}
		// Load the Excel file 
		
		logger.info("excel loading completed");
		
	}

	private static String formatData(Cell cell) {
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(cell);
	}
	public static Map<String, String> getTestCaseData(String testCaseName) {
		return sheetRows.get(testCaseName);
	}
}
