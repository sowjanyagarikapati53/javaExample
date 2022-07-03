package exampleProgram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_04
{

	public static void main(String[] args) throws Exception
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://testautomationpractice.blogspot.com/");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("RESULT_TextField-1")));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("RESULT_TextField-1"))).getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.id("RESULT_TextField-1")).sendKeys("sowjanya");
		//driver.findElement(By.id("RESULT_TextField-6")).sendKeys("hello");
		

	}

}
