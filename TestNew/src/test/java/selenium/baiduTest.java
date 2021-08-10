package selenium;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class baiduTest {
private static WebDriver driver;
private static Map<String, Object> vars;
static JavascriptExecutor js;
@BeforeClass
public  static void  setUp() {
 //System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
 //System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\geckodriver\\geckodriver.exe");
 //driver = new FirefoxDriver();
 //js = (JavascriptExecutor) driver;
 //vars = new HashMap<String, Object>();

 System.setProperty("webdriver.chrome.bin","C:\\Users\\byd_lenovo\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
 System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\geckodriver\\geckodriver.exe");
 driver = new ChromeDriver();
 js = (JavascriptExecutor) driver;
}
@Test
public void test1() {
 driver.get("https://www.baidu.com/");
 //driver.manage().window().setSize(new Dimension(1382, 744));
 driver.findElement(By.id("kw")).click();
 driver.findElement(By.id("kw")).sendKeys("selenium");
 driver.findElement(By.id("su")).click();
 //driver.findElement(By.linkText("Selenium_百度百科")).click();
}

@AfterClass
public void tearDown() {
 driver.quit();
}

}
