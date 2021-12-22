package orangehcm.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead {
	public static XSSFWorkbook book=null;
	public static XSSFSheet sheet=null;
	public int rowno=0;
	
	public static void readexcel(String excelfile,String sheetname) {
		File file = new File(excelfile);
		try {
			FileInputStream fis = new FileInputStream(file);
			book = new XSSFWorkbook(fis);
			sheet = book.getSheet(sheetname);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String,String> getData(String TCName) {
		int lastrow =  sheet.getLastRowNum();
		for(int i =1;i<lastrow;i++) {
			String CurrentTCName = sheet.getRow(i).getCell(0).getStringCellValue();
			if(CurrentTCName.equalsIgnoreCase(TCName)) {
				rowno=i;
				break;
			}
		}
		HashMap<String,String> map = new HashMap<String,String>();
		
		int lastcol = sheet.getRow(rowno).getLastCellNum();
		
		for(int i=0;i<lastcol;i++) {
			
			String ColName = sheet.getRow(0).getCell(i).getStringCellValue();
			XSSFCell cell = sheet.getRow(rowno).getCell(i);
			CellType cellType = cell.getCellType();
			
			switch (cellType) {
			case NUMERIC:
				double numberValue = cell.getNumericCellValue();
				String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();
				map.put(ColName, stringCellValue);
				break;
			case STRING:
				String cellValue = cell.getStringCellValue();
				map.put(ColName, cellValue);
				break;
			case BOOLEAN:
				boolean numberValue1 = cell.getBooleanCellValue();
				String stringCellValue1 = String.valueOf(numberValue1);
				map.put(ColName, stringCellValue1);
				break;
			case BLANK:
				map.put(ColName, null);
				break;
			default:
				System.out.println("Null Data");
			}
		}
		return map;	
	}
}
