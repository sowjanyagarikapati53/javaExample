package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E_001 
{
	public static WebDriver driver;
	public static void highlight( WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
}
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		chapter9();
		
	}
	
	public static void chapter2() 
	{
		driver.get("https://www.w3schools.com/");
        //absolute xpath
		//highlight(driver.findElement(By.xpath("html/body/div[3]/a[4]")));
		//relative xpath
		highlight(driver.findElement(By.xpath("//a[@title='Exercises']")));
	}
	//by using attributes
	public static void chapter3()
	{
		driver.get("https://www.w3schools.com/");
		//driver.findElement(By.xpath("//a[@id='w3loginbtn']")).click();
		driver.findElement(By.xpath("//a[@title=\"Search W3Schools\"]")).click();
	}
	//by using operators
	public static void chapter4() {
	driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
	//driver.findElement(By.xpath("//input[@maxlength=10]")).sendKeys("sowjanya");
	//driver.findElement(By.xpath("//input[@maxlength!=10]")).sendKeys("garikapati");
	List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength<=15]"));
	for(WebElement element : elements) {
		highlight(element);
	}
	}
	//xpath conditions
	public static void chapter5()
	{
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength=10 and name='abc' and type='t']"));
		//System.out.println(elements.size());
		//List<WebElement> elementss = driver.findElements(By.xpath("//input[@maxlength<=15 and @name='name' and@type='text']"));
		//System.out.println(elementss.size());
		List<WebElement> elements = driver.findElements(By.xpath("//input[@maxlength=10 or name='abc' or type='t']"));
		System.out.println(elements.size());
		List<WebElement> e = driver.findElements(By.xpath("//input[not(@maxlength=10)]"));
		System.out.println(e.size());
	}
	//by using index
	public static void chapter6()
	{
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		highlight(driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr[2]")));
		highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[23]")));
	}
	//xpath functions
	public static void chapter7() 
	{
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//highlight(driver.findElement(By.xpath("//a[text()='Sign in']")));
		//highlight(driver.findElement(By.xpath("//h1[text()='Register']")));
		//highlight(driver.findElement(By.xpath("//a[contains(text(),' into account')]")));//by using partial text
		//highlight(driver.findElement(By.xpath("//button[contains(@class,'tn')]")));//by using attribute
		//highlight(driver.findElement(By.xpath("//h1[starts-with(text(),'Regis')]")));
		//highlight(driver.findElement(By.xpath("//label[normalize-space(text())='First Name']")));
		//highlight(driver.findElement(By.xpath("(//table[@id='contactList']/tbody/tr)[last()]")));
		System.out.println(driver.findElements(By.xpath("(//table[@id='contactList']/tbody/tr)[position()>2]")).size());
	}
	//xpath axes
	public static void chapter8() 
	{
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//highlight(driver.findElement(By.xpath("//labelEmail']/following-sibling::input[@type='text'][text()='Email']
		//driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
		highlight(driver.findElement(By.xpath("//td[text()='Helen Bennett']/parent::tr")));
		////td[text()='Helen Bennett']/ancestor::*
		////td[text()='Helen Bennett']/ancestor-or-self::*
		////table[@id='contactList']/descendant::*
		////table[@id='contactList']/descendant-or-self::*
	}
	//xpath shortcuts
	public static void chapter9()
	{
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		//text...> .
//		highlight(driver.findElement(By.xpath("//h1[.='Register']")));
		//highlight(driver.findElement(By.xpath("//a[contains(.,'Sign in ')]")));
		//highlight(driver.findElement(By.xpath("//label[starts-with(.,'Repeat ')]")));
		//highlight(driver.findElement(By.xpath("//label[normalize-space(.)='Last Name']")));
		
		//child --> /
		//highlight(driver.findElement(By.xpath("//div[@class='container']/h1")));
		
		//parent-->/..
		//highlight(driver.findElement(By.xpath("//h1[.='Register']/..")));
		
		//descendant-->//
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='contactList']//td"));
		for(WebElement e:elements) {
			highlight(e);
		}
		
		
		
	}
	

}
