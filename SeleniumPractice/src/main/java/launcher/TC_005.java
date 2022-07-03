package launcher;

import org.openqa.selenium.By;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
		selectOption("amazondropbox_id","Books");
		typeText("amazonsearchtextbox_name","abdulKalam");
		clickElement("amazonsearchbutton_id");
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("watches");
		//driver.findElement(By.name("field-keywords")).sendKeys("women");
		//driver.findElement(By.id("nav-search-submit-button")).click();

	}



	

}
