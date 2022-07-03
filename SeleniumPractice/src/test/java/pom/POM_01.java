package pom;

import org.testng.annotations.Test;

import launcher.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class POM_01 extends BaseTest
{
	  CreatingAccount obj;
  @Test
  public void f() throws Exception 
  {
	obj = new CreatingAccount(driver);
	obj.creatingAccount();
	Assert.assertEquals(obj.registrationVerification(), "passwd is required.");
  }
  @BeforeMethod
  public void beforeMethod() throws Exception
  {
	  init();
	  launch("chromebrowser");
	  navigateUrl("automationurl");
  }

  @AfterMethod
  public void afterMethod() 
  {
  }

}
