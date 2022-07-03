package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		List<WebElement> e = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
	     int size = e.size();
	     System.out.println(size);
		String[] s = new String[e.size()];

		for(int i=0;i<e.size();i++)
		{
            s[i]=e.get(i).getText();
		}
		Arrays.sort(s);
		System.out.println("minimum number in a webtable is:"+s[0]);
		System.out.println("mamaximum number in a webtable is:"+s[size-1]);
		driver.close();

	}
}
