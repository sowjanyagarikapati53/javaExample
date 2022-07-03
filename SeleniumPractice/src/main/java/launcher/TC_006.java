package launcher;

public class TC_006 extends BaseTest1
{

	public static void main(String[] args) throws Exception
	{
		//init();
		launch("chrome");
		navigateUrl("https://www.facebook.com");
		driver.manage().window().maximize();
		System.out.println( driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.manage().deleteAllCookies();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		//driver.close();
		driver.quit();

	}

}
