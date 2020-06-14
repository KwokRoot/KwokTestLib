package testlib.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 该练习是处理图片旋转的练习。
 * @author Kwok
 */
public class Test_RotateImage {
	
	public static void main(String[] args) throws IOException {
		
		BufferedImage srcImg = ImageIO.read(new File("D://java//3.jpg"));
		BufferedImage destImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
	    Graphics2D g2 = destImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    //旋转 90°
	    g2.translate(srcImg.getWidth(), 0);
	    g2.rotate(Math.toRadians(90));
	    
	    
	    /*
	    //旋转 180°
	    g2.translate(srcImg.getWidth(), srcImg.getHeight());
	    g2.rotate(Math.toRadians(180));
	    */
	    
	    /*
	    //旋转 270°
	    g2.translate(0, srcImg.getHeight());
	    g2.rotate(Math.toRadians(270));
	    */
	    
	    g2.drawImage(srcImg, 0,0, null);
	    ImageIO.write(destImg, "png", new File("D://java/3-3.png"));
	    
	}

}
