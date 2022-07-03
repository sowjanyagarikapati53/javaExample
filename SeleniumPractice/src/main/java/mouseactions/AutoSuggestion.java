package mouseactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Hadoop tutorial");
		String value = driver.findElement(By.name("q")).getAttribute("value");
		System.out.println(value);
		List<WebElement> list = driver.findElements(By.xpath("(//div[@class='OBMEnb'])[1]/ul[@jsname='bw4e9b']/li/div/div[2]/div/span"));
//		for(WebElement i:list) 
//		{
//			System.out.println(i.getText());
//		}
		for(int i=0;i<list.size();i++)
		{
		  if(list.get(i).getText().equalsIgnoreCase(value))	
		  {
			  list.get(i).click();
			  return;
		  }
		}
	}

}
