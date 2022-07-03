package screenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy2 
{

	public static void main(String[] args) 
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		String txt1 = driver.findElement(By.linkText("Images")).getText();
		System.out.println(txt1);
		
		System.out.println("-----------------");
		
		List<WebElement> txt2 = driver.findElements(By.tagName("a"));
		for(int i=0;i<txt2.size();i++)
		{
			if(!txt2.get(i).getText().isEmpty()) {
			System.out.println(txt2.get(i).getText());
		}
		
		}
		System.out.println("-----------------");
		
		List<WebElement> txt3 = driver.findElements(By.xpath("//div[@class='gb_8d gb_f gb_mg gb_dg']/div/a"));
		for(int j=0;j<txt3.size();j++)
		{
			System.out.println(txt3.get(j).getText());
		}
		
	}

}
