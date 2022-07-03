package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exampleprogram2 
{

	public static void main(String[] args) throws  Exception
	{

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		//File
		
		File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/img1.jpg");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("screenshot saved successfully");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("https//www.facebook.com");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		
		File sourceFile1 = driver.getScreenshotAs(OutputType.FILE);
		File destFile1 = new File("./screenshots/img2.jpg");
		FileUtils.copyFile(sourceFile1, destFile1);
		System.out.println("screenshot1 saved successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[starts-with(.,'Facebook - log in ')]")).click();
		
		File sourceFile2 = driver.getScreenshotAs(OutputType.FILE);
		File destFile2 = new File("./screenshots/img3.jpg");
		FileUtils.copyFile(sourceFile2, destFile2);
		System.out.println("screenshot3 saved successfully");
		
		driver.quit();
	}

}
