package mouseactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor
{

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='sowjanya'");
		
		String title = js.executeScript(" return document.title").toString();
		System.out.println(title);
		
		js.executeScript("window.scrollBy(0,100)");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
//		js.executeScript("document.getElementById('u_0_d_fC').scrollIntoView()");
		
		js.executeScript("window.history.back()");
		
		js.executeScript("window.history.forward()");
		
		js.executeScript("window.history.go(0)");
		
	}

}
