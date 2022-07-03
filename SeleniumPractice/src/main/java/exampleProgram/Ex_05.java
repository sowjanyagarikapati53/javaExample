package exampleProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_05
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		Actions action = new Actions(driver);
	WebElement click = driver.findElement(By.xpath("//button[.='Copy Text']"));
	 WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		WebElement drag1 = driver.findElement(By.xpath("//h5[.='Mary']"));
		WebElement drop1 = driver.findElement(By.id("trash"));
		action
		.doubleClick(click)
		.dragAndDrop(drag, drop)
		.dragAndDrop(drag1, drop1)
		.perform();
		// action.click( driver.findElement(By.xpath("//a[.='Recycle image']"))).perform();
		
		
		
	}

}
