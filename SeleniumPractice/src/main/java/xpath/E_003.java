package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E_003
{

	public static void main(String[] args) 
	{
		String month="August 2022";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[contains(.,'Departure')]")).click();
		List<WebElement> months = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
		for(int i=0;i<months.size();i++)
		{
			if(!months.get(i).getText().contains(month)) {
				if(i==1) {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
					 months = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
					 i=0;
				}
			}
			else {
				System.out.println(months.get(i).getText());
				List<WebElement> days = driver.findElements(By.xpath("//div[text()='"+month+"']/following::div[@class='DayPicker-Day']"));
				for(int d=0;d<days.size();d++) {
					System.out.println(days.get(d).getText());
					 if (days.get(d).getText().contains("11"))
				       {
				        days.get(d).click();
				        return;
				       }
				}
			}
		}
	}
}


