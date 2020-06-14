package testlib.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 该练习是处理正方形图片为圆形图片的练习。
 * @author Kwok
 */
public class Test_CircleImage {

	public static BufferedImage CircleImageHandle(BufferedImage srcImg){
		BufferedImage distImg = new BufferedImage(srcImg.getWidth(),srcImg.getHeight(),BufferedImage.TYPE_4BYTE_ABGR); //透明底的图片。   
	    Ellipse2D.Double shape = new Ellipse2D.Double(0,0,srcImg.getWidth(),srcImg.getHeight());  
	    Graphics2D g2 = distImg.createGraphics();  
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //抗锯齿
	    g2.setClip(shape);
	    g2.drawImage(srcImg, 0,0, null);
		return distImg;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedImage bi = ImageIO.read(new File("D://java//1.jpg"));   
	    ImageIO.write(CircleImageHandle(bi), "png", new File("D://java//1.png")); //PNG 格式可实现图片的透明效果。
	    
	}
	
}
