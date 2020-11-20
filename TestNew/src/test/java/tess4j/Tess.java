package tess4j;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class Tess {
	
	public String path = "src/test/resources/image/8.png";
	//public String path = "src/test/resources/image/";
	public String dataPath = "src/test/resources/tessdata";
	
	//初始化文件
		public File initPicture(){
			File imageFile = new File(path);
			return imageFile;
			
		}
	
	//截屏
	public byte[] takeScreenshot(WebDriver driver) throws IOException {
		byte[] screenshot = null;
		screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);//得到截图
		return screenshot;
	}
	
	//剪裁
	public BufferedImage createElementImage(WebDriver driver,
			WebElement webElement, int x, int y)//开始裁剪的位置和截图的宽和高
			throws IOException {
		Dimension size = webElement.getSize();
		BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(
				takeScreenshot(driver)));
		BufferedImage croppedImage = originalImage.getSubimage(x, y,
				size.getWidth(), size.getHeight());//进行裁剪
		return croppedImage;
	}
	
	
	
	//读取验证码
	public String getVerificationCode(String path, WebDriver driver,WebElement element,int x,int y) {
		File imageFile = initPicture();
		//CopyOfCleanLines CL = new CopyOfCleanLines();
		try {
			BufferedImage image = createElementImage(driver, element, x, y);//得到裁剪的图片
			//System.out.println(image.getWidth());
			//image = ImageHelper.getScaledInstance(image, x*5, y* 5);//图片放大5倍
			//image = TessUtil.grayImage(image);
			//image = TessUtil.binaryImage(image);
			ImageIO.write(image, "png", imageFile);//进行保存
			//CopyOfCleanLines.cleanLinesInImage(imageFile,path);//去掉干扰线
		} catch (IOException e) {
			e.printStackTrace();
		}
		ITesseract instance = new Tesseract();//调用Tesseract
		instance.setLanguage("eng");
		instance.setDatapath(dataPath);//进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim"); 
		String result = null;
		try {
			//ImageIO.scanForPlugins();
			result = instance.doOCR(imageFile);
		} catch (TesseractException e1) {
			e1.printStackTrace();
		}
		//result = result.replaceAll("[^a-z^A-Z^0-9]", "");//替换大小写及数字
		return result;
	}
	
}
