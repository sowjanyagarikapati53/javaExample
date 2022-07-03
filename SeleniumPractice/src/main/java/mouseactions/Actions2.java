package mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions2
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		Actions a = new Actions(driver);
		WebElement drag = driver.findElement(By.id("slider"));
		//a.dragAndDropBy(drag, 100, 0).perform();
		a.clickAndHold(drag).moveByOffset(100, 0).release(drag).build().perform();
		driver.switchTo().defaultContent();
		
		//right click
	  WebElement element = driver.findElement(By.linkText("Selectable"));
	  a.contextClick(element).perform();
	}

}
