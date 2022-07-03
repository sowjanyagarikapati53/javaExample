package exampleProgram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_01
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("sowjigarikapati15");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("V4@s2106");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		driver.findElement(By.className("aAU")).click();
		//driver.findElement(By.xpath("//*[@id=\":39\"]/div/div")).click();
		//driver.findElement(By.xpath("//*[@id=\":93\"]")).sendKeys("sureshgopicse@gmail.com");
		//driver.findElement(By.name("to")).sendKeys("sureshgopicse@gmail.com");
		//driver.findElement(By.name("subjectbox")).sendKeys("wishes: Good Evening mr.suresh");
		//driver.findElement(By.xpath("//*[@id=\":9r\"]")).sendKeys("Hi..."+ "good evening suresh");
		//driver.findElement(By.xpath("//div[.='Good evening mr.suresh']/div"));
		//driver.findElement(By.xpath("//*[@id=\":8b\"]")).click();
		driver.findElement(By.xpath("(//span[.='Google Community Te.'])[2]")).click();
		
	}

}