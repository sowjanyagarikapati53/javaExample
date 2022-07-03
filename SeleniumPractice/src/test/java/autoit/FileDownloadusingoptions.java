package autoit;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadusingoptions
{

	public static void main(String[] args) throws Exception 
	{
		String filetype ="DOC, DOCX";
		WebDriver driver;
//	    WebDriverManager.chromedriver().setup();
//	    ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:\\Users\\shekar\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
//		
//		HashMap<String, Object> pref = new HashMap<String, Object>();
//		pref.put("plugins.always_open_pdf_externally", true);
//		pref.put("download.default_directory", "C:\\Users\\shekar\\Desktop");
//		options.setExperimentalOption("prefs", pref);
//		 driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get("https://file-examples.com/");
//		
		//firefox
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions option = new FirefoxOptions();
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile profile = p.getProfile("AprilFFprofile");
		
          profile.setPreference("pdfjs.disabled", true);
          profile.setPreference("browser. helperApps. neverAsk. saveToDisk", "application/pdf");
          profile.setPreference("browser. download. folderList", 0);
         option.setProfile(profile);
      	driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
	    //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h3[.='Documents']/following-sibling::a")).click();
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//td[.='"+filetype+"']/following-sibling::td/a")).click();
		driver.findElement(By.xpath("//a[starts-with(.,'Download sample ')]")).click();

	}

}
