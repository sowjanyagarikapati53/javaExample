package windowHandles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example3
{
     static WebDriver driver;
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		String parentWindowId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		ArrayList<String> hlist = new ArrayList<String>(handles);
		
		//switching to right window
		if(switchToRightWindow("LinkedIn",hlist)) {
			System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
		}
		
		//close all windows except parent window
		closeAllWindows(hlist,parentWindowId);
		
		//switch back to parent window
		switchToParentWindow(parentWindowId);
		System.out.println(driver.getCurrentUrl()+" : "+ driver.getTitle());
	}

	public static void switchToParentWindow(String parentWindowId) {
		
		driver.switchTo().window(parentWindowId);
	}

	public static void closeAllWindows(ArrayList<String> hlist, String parentWindowId) {
       for(String e : hlist) {
			if(!e.equals(parentWindowId)) {
				driver.switchTo().window(e).close();
			}
		        }
      }
	public static boolean switchToRightWindow(String windowTitle, ArrayList<String> hlist) {
		for(String e:hlist)
		{
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle))
			{
				System.out.println("found the right window....");
				return true;
			}
		}
		return false;
		
	}

}
