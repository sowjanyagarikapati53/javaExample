package verificationandreporting;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_01 
{
    public static WebDriver driver;
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
     	driver.get("https://www.amazon.in");
     	highlight(driver,driver.findElement(By.linkText("Customer Service")));
     	
       File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       FileHandler.copy(srcFile, new File("./WebdriverScreenshots/img1.png"));
	}

	  public static void highlight(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", element);
		
	}
	  

}
