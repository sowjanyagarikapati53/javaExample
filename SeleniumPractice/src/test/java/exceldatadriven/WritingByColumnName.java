package exceldatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingByColumnName
{

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\shekar\\Desktop\\login.xlsx");
		FileOutputStream fos;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("sheet1");
		XSSFRow row = sheet.getRow(0);
		
		int cellnum = 0;
		for(int i=0;i<row.getLastCellNum();i++) 
		{
		   if(row.getCell(i).getStringCellValue().trim().equals("status"))	
			   cellnum=i;
		}
		row = sheet.getRow(2);
		XSSFCell cell = row.getCell(cellnum);
		cell.setCellValue("passed");
		
	    fos = new FileOutputStream("C:\\Users\\shekar\\Desktop\\login.xlsx");
	    wb.write(fos);
		wb.close();
		fos.close();
		
		
	}

}
