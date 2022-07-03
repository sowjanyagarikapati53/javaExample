package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2 
{

	public static void main(String[] args) throws Exception
	{
		
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https:/www.google.com");
		//file	
		  File srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  File destFile = new File("./WebdriverScreenshots/img1.png");
		  FileUtils.copyFile(srcFile, destFile);		
		  System.out.println("screenshot saved successfully");
	}

}
}
