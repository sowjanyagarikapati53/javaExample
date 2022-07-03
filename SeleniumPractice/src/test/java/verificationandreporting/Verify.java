package verificationandreporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
     	driver.get("https://www.amazon.in");
     	
     	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ogeneral");
        String text = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        System.out.println(text);
     	
	}

}
