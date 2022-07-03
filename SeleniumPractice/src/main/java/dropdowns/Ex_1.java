package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_1 
{

	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		
//		WebElement courseElement = driver.findElement(By.id("course"));
//		Select courseNameDropdown = new Select(courseElement);
//		List<WebElement> couseNameDropdownOptions = courseNameDropdown.getOptions();
//		for(WebElement options : couseNameDropdownOptions) {
//			System.out.println(options.getText());
//		}
//		courseNameDropdown.selectByIndex(1);
//		Thread.sleep(3000);
//		courseNameDropdown.selectByValue("net");
//		Thread.sleep(3000);
//		courseNameDropdown.selectByVisibleText("Python");
//		
//		String selectedText = courseNameDropdown.getFirstSelectedOption().getText();
//		System.out.println("selected visible text:"+selectedText);
		
		WebElement ideElement = driver.findElement(By.id("ide"));
		Select ideDropdown = new Select(ideElement);
		List<WebElement> ideDropdownOptions = ideDropdown.getOptions();
		for(WebElement options : ideDropdownOptions) {
			System.out.println(options.getText());
		}
		ideDropdown.selectByIndex(0);
		Thread.sleep(3000);
		ideDropdown.selectByValue("ij");
		Thread.sleep(3000);
		ideDropdown.selectByVisibleText("NetBeans");
		Thread.sleep(3000);
		ideDropdown.deselectByValue("ij");
		
		List<WebElement>selectedText = ideDropdown.getAllSelectedOptions();
		for(WebElement options : selectedText)
		{
			System.out.println("selected visible text:"+options.getText());
		}

	}

}
