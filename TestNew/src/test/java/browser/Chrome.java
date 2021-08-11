package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverInfo;

public class Chrome {
    public WebDriver driver;

    public  WebDriver setUp() {
        System.setProperty("webdriver.chrome.bin","C:\\Users\\byd_lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\geckodriver\\geckodriver.exe");

        //ChromeOptions options = new ChromeOptions();
        //options.setCapability("security.enterprise_roots.enabled",true);
        //options.setCapability("security.insecure_field_warning.contextual.enabled",false);
        //options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver();
        return driver;
    }

   /*public void tearDown() {
        driver.quit();
    }*/
}
