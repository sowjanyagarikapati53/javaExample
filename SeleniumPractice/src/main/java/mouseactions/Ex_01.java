package mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_01 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Actions actions = new Actions(driver);
		actions
		.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule")))
		.moveToElement(driver.findElement(By.id("menu_admin_Organization")))
		.moveToElement(driver.findElement(By.id("menu_admin_viewLocations")))
		.click()
		.perform();
		
		driver.findElement(By.id("searchLocation_name")).sendKeys("hyderabad");
		actions.doubleClick(driver.findElement(By.id("searchLocation_name"))).perform();

	}

}
