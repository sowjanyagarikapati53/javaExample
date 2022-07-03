package launcher;

public class Tc_003 extends BaseTest1
{

	public static void main(String[] args) 
	{
		launch("firefox");
		navigateUrl("https://www.icicibank.com/");
	}

}
