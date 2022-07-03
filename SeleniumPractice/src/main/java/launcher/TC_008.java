package launcher;

import com.aventstack.extentreports.Status;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		test = rep.createTest("TC_008");
		test.log(Status.INFO,"Init the Properties files....");
		
		launch("chromebrowser");
		test.log(Status.PASS,"Opening the Browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigating to application : " + childprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selecting option Books By using locator : " + orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtextbox_name","Harry Potter");
		test.log(Status.INFO, "Typing text Harry Potter By using Locator : "+ orprop.getProperty("amazonsearchtextbox_name"));
		
		clickElement("amazonsearchbutton_id");
		test.log(Status.INFO, "Clicked on Element By ussong Locator : " + orprop.getProperty("amazonsearchbutton_id"));
		
		rep.flush();
	}

}
