package launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{

	public static WebDriver driver;
	public static String projectpath =System.getProperty("user.dir");
	public static Properties p;
	public static FileInputStream fis;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports rep;
	public static ExtentTest test;
	public static void init() throws Exception
	{
		
		fis = new FileInputStream( projectpath+"/src/test/resources/environment.properties");
		mainprop =new Properties();
		mainprop.load(fis);
		 String e = mainprop.getProperty("env");
		 System.out.println(e);
		 
		 fis = new FileInputStream( projectpath+"/src/test/resources/"+e+".properties");
		 childprop=new Properties();
		 childprop.load(fis);
		String url = childprop.getProperty("amazonurl");
		System.out.println(url);
		
		
		 fis = new FileInputStream(projectpath+"/src/test/resources/data.properties");
	     p= new Properties();
		p.load(fis);
		 p.getProperty("chromebrowser");
		//System.out.println(e);
		 
		 fis= new FileInputStream(projectpath+"/src/test/resources/or.properties");
		 orprop=new Properties();
		 orprop.load(fis);
		 
		 fis=new FileInputStream(projectpath+"/src/test/resources/log4jconfig.properties");
		 PropertyConfigurator.configure(fis);
		 
		 rep = ExtentManager.getInstance();
		
	}
	
	public static void launch(String browser)
  {
		
	if(p.getProperty(browser).equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		
	    driver= new ChromeDriver();
	}
	else if(p.getProperty(browser).equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
	    driver= new FirefoxDriver();
	}
  }
	public static void navigateUrl(String url) {
		//driver.get(url);
		driver.navigate().to(childprop.getProperty(url));
	}
	public static void clickElement(String locatorkey )
	{
		getElement(locatorkey).click();
	}

	

	public static void typeText(String locatorkey, String text)
	{
		getElement(locatorkey).sendKeys(text);
		
	}

	public static void selectOption(String locatorkey, String option)
	{
		getElement(locatorkey).sendKeys(option);
	}
	private static WebElement getElement(String locatorkey)
	{
		WebElement element =null;
		if(!isElementisPresent(locatorkey)) 
			System.out.println("Element is not present:"+locatorkey);
		element = driver.findElement(getLocator(locatorkey));
	
	/*
	 * if(locatorkey.endsWith("_id")) {
	 * element=driver.findElement(By.id(orprop.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_name")) { element=
	 * driver.findElement(By.name(orprop.getProperty(locatorkey)));
	 * 
	 * } else if(locatorkey.endsWith("_className")) { element
	 * =driver.findElement(By.className(orprop.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_tagName")) {
	 * element=driver.findElement(By.tagName(orprop.getProperty(locatorkey))); }
	 * else if(locatorkey.endsWith("_xpath")) {
	 * element=driver.findElement(By.xpath(orprop.getProperty(locatorkey))); } else
	 * if(locatorkey.endsWith("_cssSelector")) {
	 * element=driver.findElement(By.cssSelector(orprop.getProperty(locatorkey))); }
	 * else if(locatorkey.endsWith("_linkText")) {
	 * element=driver.findElement(By.linkText(orprop.getProperty(locatorkey))); }
	 * else if(locatorkey.endsWith("_partialLinkText")) { element=
	 * driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey))); }
	  */
		return element;
	}
	public static boolean isElementisPresent(String locatorkey) 
	{
		System.out.println("checking for element presence:"+locatorkey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
			/*
			 * if(locatorkey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_className")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_tagName")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(orprop.
			 * getProperty(locatorkey)))); } else if(locatorkey.endsWith("_linkText")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.
			 * getProperty(locatorkey)))); } else
			 * if(locatorkey.endsWith("_partialLinkText")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orprop.getProperty(locatorkey)))); }
			 */
		} catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public static By getLocator(String locatorkey) {
		By by=null;
		if(locatorkey.endsWith("_id")) {
			by= By.id(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name")) {
			by= By.name(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_className")) {
			by= By.className(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_xpath")) {
			by= By.xpath(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_css")) {
			by= By.cssSelector(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_linkText")) {
			by= By.linkText(orprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_partialLinkText")) {
			by= By.partialLinkText(orprop.getProperty(locatorkey));
		}
		return by;
		
	}

	//*******************  Verifications **********************
	public static boolean isLinkEqual(String expectedLink) 
	{
		String actualLink = (driver.findElement(By.linkText("Customer Service"))).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
		
	}
	
	//  ************************  Reportings  *****************
	

	public static void highlight(WebElement Element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", Element);
	}

	public static void logInfo(String logInfomation) 
	{
		test.log(Status.INFO, logInfomation);
	}
	
	public static void reportSuccess(String successMessage) 
	{
		test.log(Status.PASS, successMessage);
	}

	public static void reportFailure(String failureMessage) throws Exception 
	{
		test.log(Status.FAIL, failureMessage);
		 highlight(driver.findElement(By.linkText("Customer Service")));
		 takesScreenshot();
	}

	public static void takesScreenshot() throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectpath+"//failurescreenshots//"+dateFormat));
		
		logInfo("Screenshot --->" +test.addScreenCaptureFromPath(projectpath+"//failurescreenshots//"+dateFormat));
	}


}



