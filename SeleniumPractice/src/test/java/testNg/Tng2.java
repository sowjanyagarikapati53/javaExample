package testNg;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class Tng2 extends BaseTest
{
 
  @BeforeMethod(groups= {"regression","sanity"})
  @Parameters("browser")
  public void startUp(String bType) throws Exception
  {
	    init();
		test = rep.createTest("TC_008");
		test.log(Status.INFO,"Init the Properties files....");
		
		launch(bType);
		test.log(Status.PASS,"Opening the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigating to application : " + childprop.getProperty("amazonurl"));
  }
  
  @Test(groups= {"regression","sanity"})
  public void amazon() 
  {
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selecting option Books By using locator : " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtextbox_name","Harry Potter");
		test.log(Status.INFO, "Typing text Harry Potter By using Locator : "+ orprop.getProperty("amazonsearchtextbox_name"));
		
		clickElement("amazonsearchbutton_id");
		test.log(Status.INFO, "Clicked on Element By ussong Locator : " + orprop.getProperty("amazonsearchbutton_id"));
		
  }

  @AfterMethod(groups= {"regression","sanity"})
  public void afterMethod() 
  {
	 rep.flush();
	 driver.quit();
  }

}
