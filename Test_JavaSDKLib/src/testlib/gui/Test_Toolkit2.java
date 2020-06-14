package testlib.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 该练习是对 java.awt.Toolkit 的练习。
 * @author Kwok
 */
public class Test_Toolkit2 extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		//kit.beep(); //发出一个音频提示声。
		
		System.out.println(kit.getScreenSize()); //获取屏幕分辨率。
		
		Image image = null;
		try {
			//异步获取图片对象。
			image = kit.getImage(new URL("http://ucanmax-10011087.image.myqcloud.com/608d74c4-10a3-476a-b5bf-9db3b2daf2c2"));
			System.out.println("1秒前：" + image.getWidth(null));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			System.out.println("1秒后：" + image.getWidth(null));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		//同步获取图片对象。
		Image src = ImageIO.read(new URL("http://ucanmax-10011087.image.myqcloud.com/608d74c4-10a3-476a-b5bf-9db3b2daf2c2"));
		System.out.println(src.getWidth(null));
		*/
		
		BufferedImage bi = convertToBufferedImage(image);
		try {
			ImageIO.write(bi, "jpg", new File("d:\\a.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static BufferedImage convertToBufferedImage(Image image){

		System.out.println(image.getWidth(null));
	    BufferedImage newImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_3BYTE_BGR);
	    Graphics2D g = newImage.createGraphics();
	    g.drawImage(image, 0, 0, null);
	    
	    return newImage;
	    
	}
	
}
