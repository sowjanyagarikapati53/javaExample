package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example3 
{

	public static void main(String[] args) throws Exception
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys("hello");//main web page
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Select course =new Select(driver.findElement(By.id("course")));
		course.selectByVisibleText("Python");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("main");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.id("frm2")));
		driver.findElement(By.id("firstName")).sendKeys("sowjanya");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Select course1 =new Select(driver.findElement(By.id("course")));
		course1.selectByVisibleText("Dot Net");
		

	}

}
