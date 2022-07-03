package windowHandles;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1
{

	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		
	/*	//single window
		String parentwindowhandle = driver.getWindowHandle();
		System.out.println("parent window handle -"+parentwindowhandle +driver.getTitle());
		driver.findElement(By.id("newWindowBtn")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		for(String windowhandle : windowhandles) {
			if(!windowhandle.equals(parentwindowhandle))
			{
				driver.switchTo().window(windowhandle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("sowjanya");
				Thread.sleep(3000);
				driver.close();
			}
			
			
		}
		driver.switchTo().window(parentwindowhandle);
		driver.findElement(By.id("name")).sendKeys("selenium");*/
	
		//single tab
		String parentwindowhandle = driver.getWindowHandle();
		System.out.println("parent window handle -"+parentwindowhandle +driver.getTitle());
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> windowhandles = driver.getWindowHandles();
		for(String windowhandle : windowhandles) {
			if(!windowhandle.equals(parentwindowhandle))
			{
				driver.switchTo().window(windowhandle);
				//driver.manage().window().maximize();
				System.out.println(driver.findElement(By.id("output")).getText());
				driver.findElement(By.id("alertBox")).click();
				Alert simpleAlert = driver.switchTo().alert();
				System.out.println(simpleAlert.getText());
				//Thread.sleep(1000);
				simpleAlert.accept();
				//Thread.sleep(1000);
				driver.close();
			}
		}
			driver.switchTo().window(parentwindowhandle);
			driver.findElement(By.id("name")).sendKeys("selenium");
			Thread.sleep(2000);
			driver.quit();
	}

}

