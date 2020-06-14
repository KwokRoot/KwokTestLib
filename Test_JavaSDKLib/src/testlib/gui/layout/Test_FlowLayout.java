package testlib.gui.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 该练习是对 FlowLayout 流布局的练习。
 * @author Kwok
 */
public class Test_FlowLayout extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Test_FlowLayout flowLayoutFrame = new Test_FlowLayout();
		flowLayoutFrame.setSize(800, 600);
		flowLayoutFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		flowLayoutFrame.setVisible(true);
		flowLayoutFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		flowLayoutFrame.add(new JButton("按钮1"));
		flowLayoutFrame.add(new JButton("按钮2"));
		flowLayoutFrame.add(new JButton("按钮3"));
		flowLayoutFrame.add(new JButton("按钮4"));
		flowLayoutFrame.add(new JButton("按钮5"));
		flowLayoutFrame.add(new JButton("按钮6"));
		flowLayoutFrame.add(new JButton("按钮7"));
		flowLayoutFrame.add(new JButton("按钮8"));
		flowLayoutFrame.add(new JButton("按钮9"));
		flowLayoutFrame.add(new JButton("按钮10"));
		flowLayoutFrame.add(new JButton("按钮11"));
		flowLayoutFrame.add(new JButton("按钮12"));
		flowLayoutFrame.add(new JButton("按钮13"));
		flowLayoutFrame.add(new JButton("按钮14"));
		flowLayoutFrame.add(new JButton("按钮15"));
		flowLayoutFrame.add(new JButton("按钮16"));
		
		flowLayoutFrame.validate();	//验证此容器及其所有子组件，再次布置其子组件。
		//flowLayoutFrame.pack();	//调整此窗口的大小，以适合其子组件的首选大小和布局。
	}

}
