package utilities;

public class ExcelUtilsTest {

	public static void main(String[] args) {
		String excelPath="./excelData/data.xlsx";
		String sheetname="Sheet1";
		ExcelUtilities excel=new ExcelUtilities(excelPath, sheetname);
		excel.getRowCount();
		excel.getCellData();

	}

}
