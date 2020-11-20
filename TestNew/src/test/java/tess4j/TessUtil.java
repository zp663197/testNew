package tess4j;

import java.awt.image.BufferedImage;

public class TessUtil {
	/**
	 * 裁剪图片：去掉黑边
	 */
	public static BufferedImage clipImage(BufferedImage srcImage) {
	    return srcImage.getSubimage(1, 1, srcImage.getWidth() - 2, srcImage.getHeight() - 2);
	}

	/**
	 * 灰度化
	 */
	public static BufferedImage grayImage(BufferedImage srcImage) {
	    return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY));
	}

	/**
	 * 二值化
	 */
	public static BufferedImage binaryImage(BufferedImage srcImage) {
	    return copyImage(srcImage, new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY));
	}

	public static BufferedImage copyImage(BufferedImage srcImage, BufferedImage destImage) {
	    for (int y = 0; y < srcImage.getHeight(); y++) {
	        for (int x = 0; x < srcImage.getWidth(); x++) {
	            destImage.setRGB(x, y, srcImage.getRGB(x, y));
	        }
	    }
	    return destImage;
	}
	
	/*//处理倾斜
	public void testDoOCR_SkewedImage() throws Exception {
        //设置语言库
        instance.setDatapath(testResourcesLanguagePath);
        instance.setLanguage("chi_sim");

        logger.info("doOCR on a skewed PNG image");
        File imageFile = new File(this.testResourcesDataPath, "ocr_skewed.jpg");
        BufferedImage bi = ImageIO.read(imageFile);
        ImageDeskew id = new ImageDeskew(bi);
        double imageSkewAngle = id.getSkewAngle(); // determine skew angle
        if ((imageSkewAngle > MINIMUM_DESKEW_THRESHOLD || imageSkewAngle < -(MINIMUM_DESKEW_THRESHOLD))) {
            bi = ImageHelper.rotateImage(bi, -imageSkewAngle); // deskew image
        }

        String result = instance.doOCR(bi);
        logger.info(result);
    }*/
	
}
