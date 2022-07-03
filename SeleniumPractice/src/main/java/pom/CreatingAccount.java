package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingAccount 
{
	@FindBy(linkText="Sign in") WebElement signIn;
	@FindBy(id="email_create") WebElement email;
	@FindBy(id = "SubmitCreate") WebElement creating;
	//@FindBy(xpath="//input[@id='id_gender2']") WebElement gender;
	@FindBy(xpath = "//input[@id='customer_firstname']") WebElement name;
	@FindBy(xpath = "//input[@id='customer_lastname']") WebElement lastName;
	@FindBy(id = "phone") WebElement mobile;
	@FindBy(id = "submitAccount") WebElement register;
	
	@FindBy(xpath = "//ol/li") WebElement registrationerr;


	public CreatingAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


   public void creatingAccount() throws Exception
	{
		signIn.click();
		email.sendKeys("sowji@gmail.com");
		creating.click();
		Thread.sleep(3000);
		//gender.click();
		Thread.sleep(3000);
		name.sendKeys("sowjnaya");
		Thread.sleep(3000);
		lastName.sendKeys("garikapati");
		mobile.sendKeys("12345");
		Thread.sleep(3000);
		register.click();

	}
   public String registrationVerification() 
   {
	   return registrationerr.getText();
   }
}
