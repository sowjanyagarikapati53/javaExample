package verificationandreporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 
{

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
     	driver.get("https://www.amazon.in");
        //String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
        String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
        String expectedLink = "Customer Serv";
        
        System.out.println("actual link :"+actualLink);
        System.out.println("expected link :"+expectedLink);
        
       // if(actualLink.equals(expectedLink))
       // if(actualLink.equalsIgnoreCase(expectedLink))
        if(actualLink.contains(expectedLink))
        	System.out.println("both the links are equal...");
        else
        	System.out.println("both the links are not equal.....");
	}

}
