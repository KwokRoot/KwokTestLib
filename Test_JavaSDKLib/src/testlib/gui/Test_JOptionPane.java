package testlib.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.IconUIResource;

/**
 * 该练习是对 JOptionPane 提示框样式自定义设置的练习。
 * @author Kwok
 */
public class Test_JOptionPane {
	
	public static void main(String[] args) {
		
		// 设置按钮显示效果
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.BOLD, 30)));
		// 设置文本显示效果
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.BOLD, 40)));
		// 设置窗口显示尺寸
		//UIManager.put("OptionPane.minimumSize", new DimensionUIResource(300, 600));
		
		// 定义一个 Icon 
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new URL("http://www.ucanmax.com/static/image/wrong_bg.png"));
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image image = bufferedImage.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(image);
		
		// 设置选项
		Object[] possibleValues = { "选项1", "选项2", "取消" };
		
		// 设置消息类型提示图标
		//UIManager.put("OptionPane.informationIcon", new IconUIResource(new ImageIcon(image)));
		
		Object selectedValue = JOptionPane.showOptionDialog(null, "选择", "提示：",  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, imageIcon, possibleValues, possibleValues[1]);
		
		System.out.println(selectedValue);
		
		System.exit(0);
		
	}
	
}
