package windowHandles;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.icicibank.com/");
		driver.manage().window().maximize();
		
		String parentwindowhndle = driver.getWindowHandle();
		System.out.println(parentwindowhndle);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		while(!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@alt='CC'][@class='lazy loaded'])[1]"))).isDisplayed());
		{
			driver.findElement(By.xpath("//div[@class='banner-slider i-home-banner desktop slick-initialized slick-slider slick-dotted']/button[@class='slick-next slick-arrow']")).click();
		}
		driver.findElement(By.xpath("(//img[@alt='CC'][@class='lazy loaded'])[1]")).click();
		Set<String> window = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<String>(window);
		for(String i : windows) {
			System.out.println(i);
		}
		driver.switchTo().window(windows.get(1));
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.close();
		
		driver.switchTo().window(windows.get(0));
		
		String title2 = driver.getTitle();
		System.out.println(title2);
	}

}
