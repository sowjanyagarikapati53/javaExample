package exampleProgram;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_02 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	      String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("amazon.com");
		driver.findElement(By.className("wikipedia-search-button")).click();
		//driver.findElement(By.xpath("//a[.='Amazon.com']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Amazon.com")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		for(String windowhandle: windowhandles) 
		{
			if(!windowhandle.equals(parentwindow))
			{
			 driver.switchTo().window(windowhandle);
			driver.findElement(By.xpath("//span[.='Main page']")).click();
			driver.close();
			}
		}
		//alert handling
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//button[.='Click Me']")).click();
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(2000);
		al.accept();
		
		//date picker
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//a[.='28']")).click();
	 
	}	
	

}
