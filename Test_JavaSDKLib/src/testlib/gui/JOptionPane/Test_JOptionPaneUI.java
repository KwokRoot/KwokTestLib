package testlib.gui.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * 该练习是对 JOptionPane 提示框样式自定义设置的练习。
 * @author Kwok
 */
public class Test_JOptionPaneUI {
	
	public static void main(String[] args) {
		
		// 设置文本显示效果
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.BOLD, 30)));
		// 设置按钮显示效果
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.BOLD, 20)));
		// 设置窗口显示尺寸
		//UIManager.put("OptionPane.minimumSize", new DimensionUIResource(300, 600));
		
		// 定义一个 Icon
		BufferedImage bufferedImage = null;
		
		try {
			bufferedImage = ImageIO.read(Test_JOptionPaneUI.class.getResource("Test_JOptionPaneUI.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon imageIcon = new ImageIcon(image);
		
		// 设置选项
		Object[] possibleValues = { "选项1", "选项2", "取消" };
		
		// 设置消息类型提示图标
		//UIManager.put("OptionPane.informationIcon", new IconUIResource(new ImageIcon(image)));
		//Object selectedValue = JOptionPane.showOptionDialog(null, "请选择", "提示：",  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[1]);
		
		Object selectedValue = JOptionPane.showOptionDialog(null, "请选择", "提示：",  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, imageIcon, possibleValues, possibleValues[1]);
		
		System.out.println(selectedValue);
		
		//System.exit(0);	//JOptionPane 弹出框执行后，程序依然处于阻塞状态。
		
	}
	
}
