package verificationandreporting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import launcher.BaseTest;

public class Report1 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		test = rep.createTest("Report1");
		logInfo("Init properties files------");
		
		launch("chromebrowser");
		driver.manage().window().maximize();
		logInfo("launching the chrome browser :"+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		logInfo("navigating to application :"+childprop.getProperty("amazonurl"));
		
        String expectedLink = "Customer Serv";
       
		if(!isLinkEqual(expectedLink))
			reportFailure("Both Links are not equal...");
		else
			reportSuccess("Both Links are equal...");
		
		rep.flush();
		
		
	}

}
