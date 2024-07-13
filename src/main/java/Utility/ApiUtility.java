package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApiUtility {
	
	
	public static String ReadPropertiesFile(String value) {
		
		String path = "src\\main\\java\\propertiesfiles\\Apibase.properties";
		Properties prop = new Properties();
		try {
		    prop.load(new FileInputStream(path));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return  prop.getProperty(value);
	}
	
	public static String ReadXLTestData(String key) throws InvalidFormatException, IOException {
		String value = null;
		File file = new File("TestData.xlsx"); 
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFRow row = sheet.getRow(0);
		XSSFRow row1 = sheet.getRow(1);
		for(int i=0;i<row.getPhysicalNumberOfCells();i++) {
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(key)) {
				if(row1.getCell(i).getCellType().toString().equalsIgnoreCase("NUMERIC")) {
					value = Double.toString(row1.getCell(i).getNumericCellValue());
				} else if(row1.getCell(i).getCellType().toString().equalsIgnoreCase("STRING")) {
					value = row1.getCell(i).getStringCellValue();
				}
			}
		}
		return value;	
	}

}
