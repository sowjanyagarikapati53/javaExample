package testNGAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertion
{
  @Test
  public void f()
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  
	String actualtitle = driver.getTitle();
	String expextedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon";
	
	//Assert.assertEquals(actualtitle, expextedtitle);
	Assert.assertTrue(actualtitle.equals(expextedtitle), "both titles are not equal....");
	driver.findElement(By.linkText("Customer Service")).click();
	
  }
}
