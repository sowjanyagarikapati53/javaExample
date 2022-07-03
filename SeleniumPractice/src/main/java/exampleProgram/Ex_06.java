package exampleProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_06 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
        int rows = driver.findElements(By.xpath("//table/tbody/tr")).size();
        System.out.println("number of rows in a table:"+rows);
        int columns = driver.findElements(By.xpath("//table/tbody/tr/td")).size();
        System.out.println("number of colums in a table:"+columns);
      WebElement value = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]"));
      System.out.println("subject of learn java:"+value.getText());
     List<WebElement> price = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
     for(WebElement e:price) {
    	 System.out.println(e.getText());
     }
	}

}
