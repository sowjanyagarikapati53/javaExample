package browserlaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 
{
   public static void main(String[] args) 
   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\shekar\\Desktop\\sowjanya\\Selenium\\Resources\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.amazon.in/ref=gno_logo");
	   driver.manage().window().maximize();
	
}
}
