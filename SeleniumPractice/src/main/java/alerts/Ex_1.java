package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Ex_1
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		//simple alert
		driver.findElement(By.id("alertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(1000);
		simpleAlert.accept();
		Thread.sleep(1000);
		
		//conformation alert
		//driver.findElement(By.id("confirmBox")).click();
		//Alert conformationAlert = driver.switchTo().alert();
		//System.out.println(conformationAlert.getText());
		//Thread.sleep(2000);
		//conformationAlert.accept();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.id("output")).getText());
		
		//prompt alert
		//driver.findElement(By.id("promptBox")).click();
	//Alert promptAlert = driver.switchTo().alert();
		//System.out.println(promptAlert.getText());
		//Thread.sleep(2000);
		 //promptAlert.sendKeys("sowjanya");
		//promptAlert.accept();
		//Thread.sleep(2000);
		//System.out.println(driver.findElement(By.id("output")).getText());

         driver.close();
	}

}
