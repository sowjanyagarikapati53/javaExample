package exceldatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingUsingColumnNum
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\shekar\\Desktop\\login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(0);
		String str = cell.getStringCellValue();
		System.out.println(str);
		
		
		wb.close();
		fis.close();
		
	}

}
