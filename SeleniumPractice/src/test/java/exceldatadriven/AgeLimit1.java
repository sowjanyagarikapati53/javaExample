package exceldatadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AgeLimit1
{

	public static void main(String[] args) throws Exception
	{

		FileInputStream fis = new FileInputStream("C:\\Users\\shekar\\Desktop\\Age.xlsx");
		FileOutputStream fos;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);

		int cellindex=0;
		for(int i=1;i<row.getLastCellNum();i++)
		{

			if(row.getCell(i).getStringCellValue().trim().equals("age")) 
				cellindex=i;
				for(int j=0;j<9;j++)
				{
					
					//cellindex=i;
					row = sheet.getRow(j);
					XSSFCell cell = row.getCell(cellindex);
					double str = cell.getNumericCellValue();
					System.out.println(str);
//					//					int cellnum1=0;
//					if(str>=18.0) { 
//						//	FileInputStream fis1 = new FileInputStream("C:\\Users\\shekar\\Desktop\\age.xlsx");
//						//XSSFWorkbook wb = new XSSFWorkbook(fis);
//						//XSSFSheet sheet = wb.getSheet("sheet1");
//						//XSSFRow row1 = sheet.getRow(j);
//						XSSFCell cell1 = row.getCell(j);
//						cell1.setCellValue("eligible");
//
//						fos = new FileOutputStream("C:\\Users\\shekar\\Desktop\\Age.xlsx");
//						wb.write(fos);
//						wb.close();
//						fos.close();

//					}	

				}
		}

	}
}

