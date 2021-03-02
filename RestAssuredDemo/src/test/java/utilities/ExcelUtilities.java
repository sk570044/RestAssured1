package utilities;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	static XSSFWorkbook worbook;
	static XSSFSheet sheet;
	
	public ExcelUtilities(String excelPath, String sheetName)
	{
		System.out.println("Hellow");
		try {
		 worbook=new XSSFWorkbook(excelPath);
	     sheet=worbook.getSheet(sheetName);
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	
	public static void  getCellData()
	{
			String  value = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(value);
			
			double  value1 = sheet.getRow(1).getCell(2).getNumericCellValue();
			System.out.println(value1);
			
			DataFormatter formatter =new DataFormatter();
			Object value3 = formatter.formatCellValue(sheet.getRow(1).getCell(2));
			Object value4 = formatter.formatCellValue(sheet.getRow(2).getCell(0));
			System.out.println(value4);

	}
	
	public static void getRowCount()
	{		
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("No. of rows "+rowCount);
	}

}
