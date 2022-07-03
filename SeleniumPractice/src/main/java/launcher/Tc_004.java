package launcher;

public class Tc_004 extends BaseTest1
{

	public static void main(String[] args) 
	{
		launch("firefox");
		navigateUrl("https://expired.badssl.com/");
	}

}
