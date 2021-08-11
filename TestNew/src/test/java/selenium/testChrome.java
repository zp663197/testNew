package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import browser.Chrome;

public class testChrome {
 private static WebDriver driver;

@BeforeClass
public  static void  setUp() {
 Chrome c = new Chrome();
 driver = c.setUp();
}
@Test
public void testC() {
 driver.get("https://www.baidu.com/");
 //driver.manage().window().setSize(new Dimension(1382, 744));
 //driver.findElement(By.id("kw")).click();
 driver.findElement(By.id("kw")).sendKeys("selenium");
 driver.findElement(By.id("su")).click();
 //driver.findElement(By.linkText("Selenium_百度百科")).click();
}

@AfterClass
public void tearDown() {
 driver.quit();
}

}
