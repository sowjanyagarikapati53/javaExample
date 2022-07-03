package calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
//		int day = 1;
//		
//		//First calendar
//		driver.findElement(By.id("first_date_picker")).click();
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();
//		
//		//second calendar
//		driver.findElement(By.id("second_date_picker")).click();
//		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+day+"]")).click();
		
		String targetDate="20/Feb/2023";
		Calendar calendar = Calendar.getInstance();
		try 
		{
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormat.setLenient(false);
			Date FormatedDate = targetDateFormat.parse(targetDate);
			calendar.setTime(FormatedDate);
		} 
		catch (ParseException e) 
		{
			throw new Exception("inavalid date is provided ,please check once....");
		}
			int targetedmonth = calendar.get(calendar.MONTH);
			int targetedYear = calendar.get(calendar.YEAR);
			int targetDay = calendar.get(calendar.DAY_OF_MONTH);
			driver.findElement(By.id("second_date_picker")).click();
			//May 2022
			String currentdate = driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentdate));
			int currentmonth = calendar.get(calendar.MONTH);
			int currentYear = calendar.get(calendar.YEAR);
			
			while(currentmonth<targetedmonth||currentYear<targetedYear) {
				driver.findElement(By.className("ui-datepicker-next")).click();
			    currentdate = driver.findElement(By.className("ui-datepicker-title")).getText();
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(currentdate));
				 currentmonth = calendar.get(calendar.MONTH);
			    currentYear = calendar.get(calendar.YEAR);
			}
			if(currentmonth==targetedmonth&&currentYear==targetedYear)
			driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+targetDay+"]")).click();
			else
				throw new Exception("unable to select the because of current and target date mismatch");
		}
		

	}


