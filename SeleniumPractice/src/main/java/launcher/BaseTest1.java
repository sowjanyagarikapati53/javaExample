package launcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1
{
	public static WebDriver driver;
	public static void launch(String browser) {
		
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 ProfilesIni p =new  ProfilesIni();
		FirefoxProfile profile = p.getProfile("AprilFFprofile");
		FirefoxOptions option = new FirefoxOptions();
		option.setProfile(profile);
		//Handling Notifications
		profile.setPreference("dom.webnotifications.enabled", false);
		
		//certificate error handling
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		driver=new FirefoxDriver(option);
		
		
		
	}

}
	public static void navigateUrl(String url) {
		driver.get(url);
		//driver.navigate().to(url);
	}
}
