package testlib.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 该练习是对 java.awt.Toolkit 类的练习。
 * @author Kwok
 */
public class Test_Toolkit {

	public static void main(String[] args) throws MalformedURLException {

		System.out.println("------------------------------ 操作 1:获取屏幕分辨率大小 ------------------------------");
		
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize()); // 获取屏幕的大小。
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		double width = dimension.getWidth();// 获取屏幕长
		double height = dimension.getHeight();// 获取屏幕宽
		System.out.println(width);
		System.out.println(height);

		
		System.out.println("------------------------------ 操作 2:发出一个音频嘟嘟声 ------------------------------");
		
		Toolkit.getDefaultToolkit().beep();
		
		
		System.out.println("------------------------------ 操作3: 实现简单图片查看器------------------------------");
		
		Image image = Toolkit.getDefaultToolkit().getImage(new URL("http://ucanmax.com/static/image/index_service2.jpg"));
		//Image image = Toolkit.getDefaultToolkit().getImage("D:\\3mbt.jpg");
		
		JFrame jFrame = new JFrame("图像阅读器");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		jFrame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		MyPanel myPanel = new MyPanel(image);
		jFrame.add(myPanel);
		
		jFrame.setVisible(true);
	}

}

class MyPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Image img;
	
	public MyPanel(Image img) {
		this.img = img;
		System.out.println(img.getHeight(null));
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, (this.getWidth()-img.getWidth(null))/2, (this.getHeight()-img.getHeight(null))/2, null);
	}

}