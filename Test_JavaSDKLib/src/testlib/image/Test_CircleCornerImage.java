package testlib.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 该练习是处理图片为圆角图片的练习。
 * 当图片为正方形，圆角直径(参数：cornerDiameter)为图片长(宽)像素时，可处理为圆形图片。
 * @author Kwok
 */
public class Test_CircleCornerImage {

	public static BufferedImage CircleCornerImageHandle(BufferedImage srcImg, int cornerDiameter){
		BufferedImage distImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = distImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setComposite(AlphaComposite.Src);
	    g2.setColor(Color.WHITE);
	    g2.fill(new RoundRectangle2D.Float(0, 0, srcImg.getWidth(), srcImg.getHeight(), cornerDiameter, cornerDiameter));
	    g2.setComposite(AlphaComposite.SrcAtop);
	    g2.drawImage(srcImg, 0,0, null);
		return distImg;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedImage bi = ImageIO.read(new File("D://java//1.jpg"));
		ImageIO.write(CircleCornerImageHandle(bi, 100), "png", new File("D://java//1.png")); //PNG 格式可实现图片的透明效果。
	    ImageIO.write(CircleCornerImageHandle(bi, bi.getWidth()), "png", new File("D://java//2.png")); //PNG 格式可实现图片的透明效果。
	    
	}
	
}
