package testNGAssertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertion 
{
  @Test
  public void f()
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  
	String actualtitle = driver.getTitle();
	String expextedtitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	SoftAssert s = new SoftAssert();
	//s.assertEquals(actualtitle, expextedtitle);
	s.assertTrue(actualtitle.equals(expextedtitle),"both titles are not equal....");
	
	s.assertTrue(false, "err1");
	
	s.assertTrue(true, "err2");
	
	s.assertTrue(false, "err3");
	
	s.assertTrue(false, "err4");
	
    driver.findElement(By.linkText("Customer Service")).click();
    s.assertAll();
  }
}
