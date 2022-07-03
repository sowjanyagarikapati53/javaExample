package exampleProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_03
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement selectmenu = driver.findElement(By.id("speed"));
		Select dropdown =new Select(selectmenu);
		List<WebElement> dropdownoption = dropdown.getOptions();
		for(WebElement options: dropdownoption) {
			System.out.println(options.getText());
		}
		dropdown.selectByVisibleText("Medium");
		WebElement Selectnumber = driver.findElement(By.id("number"));
		Select numberDropdown = new Select(Selectnumber);
		List<WebElement> numberdropdownoptions = numberDropdown.getOptions();
		for(WebElement options1: numberdropdownoptions) {
			System.out.println(options1.getText());
		}
		
		numberDropdown.selectByIndex(2);

	}

}
