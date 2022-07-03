package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E_002 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		String price = driver.findElement(By.xpath("//a[contains(text(),'Omax Auto')]/parent::*//following-sibling::td[3]")).getText();
		System.out.println(price);
		String price1 = driver.findElement(By.xpath("//a[contains(.,'Lahoti Overseas')]/parent::*//following-sibling::td[2]")).getText();
		System.out.println(price1);
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("no of rows in a table is:"+elements.size());
		int elements1 = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th")).size();
		System.out.println("no of columns in a table:"+elements1);
		List<WebElement> e = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
		for(WebElement i:e) {
			System.out.println(i.getText());
		}
			
	}

}
