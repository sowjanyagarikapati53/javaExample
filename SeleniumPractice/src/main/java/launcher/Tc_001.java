package launcher;

public class Tc_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		driver.manage().window().maximize();
	}

}
