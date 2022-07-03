package staleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementException
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pavantestingtools.com/");
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Online Training']"));
		link.click();
		 driver.navigate().back();
		try
		{ 
		 link.click();
	    }
		catch(StaleElementReferenceException e)
		{
			 link = driver.findElement(By.xpath("//a[text()='Online Training']"));
			link.click();
		}
	}
}
