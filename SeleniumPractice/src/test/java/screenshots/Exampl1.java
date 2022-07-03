package screenshots;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exampl1
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:/www.google.com");
	//file	
//	  File srcFile = driver.getScreenshotAs(OutputType.FILE);
//	  File destFile = new File("./WebdriverScreenshots/img1.png");
//	  FileUtils.copyFile(srcFile, destFile);
//	  System.out.println("screenshot saved successfully");
		
		//bytes
//		   byte[] byteArr = driver.getScreenshotAs(OutputType.BYTES);
//		   File destFile = new File("./WebdriverScreenshots/img1.png");
//		   FileOutputStream fos = new FileOutputStream(destFile);
//		   fos.write(byteArr);
//		   fos.close();
//		   System.out.println("screenshot saved successfully");
		   
		   //Base64
		   String base64code  = driver.getScreenshotAs(OutputType.BASE64);
		   byte[] bytArr =java.util.Base64.getDecoder().decode(base64code);
		   File destFile = new File("./WebdriverScreenshots/img1.png");
		   FileOutputStream fos = new FileOutputStream(destFile);
		   fos.write(bytArr);
		   fos.close();
		   System.out.println("screenshot saved successfully");
		   
		   
	       driver.quit();
	}

}
