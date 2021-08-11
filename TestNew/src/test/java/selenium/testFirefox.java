package selenium;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import browser.Firefox;
import tess4j.Tess;

public class testFirefox{
  
	public WebDriver driver;
	//Tess t = new Tess();

  @BeforeClass
  public void setUp(){
	  Firefox f = new Firefox();
	  driver = f.setUp();
  }
  
  @Test
  public void testF() throws IOException, InterruptedException {

	  driver.get("https://www.baidu.com/");
	  //driver.manage().window().setSize(new Dimension(1382, 744));
	  //driver.findElement(By.id("kw")).click();
	  driver.findElement(By.id("kw")).sendKeys("selenium");
	  driver.findElement(By.id("su")).click();
	  //driver.findElement(By.linkText("Selenium_百度百科")).click();

	  //driver.get("http://weixin16.bydauto.com.cn/");
	  //driver.findElement(By.name("username")).sendKeys("zhang.peng84@byd.com");
	  //driver.findElement(By.name("password")).sendKeys("663197");
	  
	  //do{
	  /*WebElement picture = driver.findElement(By.id("verifyCode"));
	  int x = picture.getLocation().getX();
	  int y = picture.getLocation().getY();
	  String s = t.getVerificationCode(t.path,driver,picture,x,y);
	  System.out.println(s);
	  Thread.sleep(1000);
	  driver.findElement(By.id("verifyCodeInput")).sendKeys(s);*/
	  //driver.findElement(By.tagName("button")).click();
	  //}
	  //while(driver.getCurrentUrl().equals("http://weixin16.bydauto.com.cn/index/login/login.html"));
	  
	  
  }
  
  @AfterClass
  public void after(){
	  driver.quit();
  }
  
}
