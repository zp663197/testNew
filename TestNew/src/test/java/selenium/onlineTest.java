package selenium;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import browser.Firefox;
import tess4j.Tess;

public class onlineTest{
  
	public WebDriver driver;
	Firefox f = new Firefox();
	Tess t = new Tess();
  
  @BeforeClass
  public void before(){
	  driver = f.setUp();
  }
  
  @Test
  public void doTest() throws IOException, InterruptedException {
	  driver.get("http://weixin16.bydauto.com.cn/");
	  driver.findElement(By.name("username")).sendKeys("zhang.peng84@byd.com");
	  driver.findElement(By.name("password")).sendKeys("663197");
	  
	  //do{
	  /*WebElement picture = driver.findElement(By.id("verifyCode"));
	  int x = picture.getLocation().getX();
	  int y = picture.getLocation().getY();
	  String s = t.getVerificationCode(t.path,driver,picture,x,y);
	  System.out.println(s);
	  Thread.sleep(1000);
	  driver.findElement(By.id("verifyCodeInput")).sendKeys(s);*/
	  driver.findElement(By.tagName("button")).click();
	  //}
	  //while(driver.getCurrentUrl().equals("http://weixin16.bydauto.com.cn/index/login/login.html"));
	  
	  
  }
  
  /*@AfterClass
  public void after(){
	  f.tearDown();
  }*/
  
}
