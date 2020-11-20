package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Firefox {
public WebDriver driver;

	//public Firefox(){}
	
	public  WebDriver setUp() {
		 System.setProperty("webdriver.firefox.bin","D:\\firefox\\firefox.exe");
		 System.setProperty("webdriver.gecko.driver","D:\\firefox\\geckodriver.exe");
//		 System.setProperty("webdriver.firefox.marionette", "false");
		 FirefoxOptions options = new FirefoxOptions();
		 FirefoxProfile p =new FirefoxProfile();
		 p.setPreference("security.enterprise_roots.enabled", true);
		 //去掉不安全密码警示
		 p.setPreference("security.insecure_field_warning.contextual.enabled", false);
		 options.setProfile(p);
		 options.setLogLevel(FirefoxDriverLogLevel.FATAL);
		 options.setAcceptInsecureCerts(true);
//		 options.setHeadless(true);
		 WebDriver driver = new FirefoxDriver(options);
		 return driver;
		}
	
	public void tearDown() {
		 driver.quit();
		}
}
