package testlib.gui.component;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 该练习是对 Frame-窗口 的练习。
 * @author Kwok
 */
public class Test_Component {

	public static void main(String[] args) {
		
		//设置 Frame 属性
		Frame frame = new Frame();
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setTitle("Fream-测试");
		frame.setBackground(Color.darkGray);
		frame.setLocationRelativeTo(null);	//将窗口置于屏幕的中央。
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent paramWindowEvent) {
				System.out.println(paramWindowEvent.paramString());
				System.exit(0);
			}
		});
		
		frame.validate();	//验证此容器及其所有子组件，再次布置其子组件。
		//frame.pack();	//调整此窗口的大小，以适合其子组件的首选大小和布局。
		
	}
}
