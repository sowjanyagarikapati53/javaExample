package launcher;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaucher
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	}

}
