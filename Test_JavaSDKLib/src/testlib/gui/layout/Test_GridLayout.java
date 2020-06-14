package testlib.gui.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 该练习是对 GridLayout 矩形网格布局的练习。
 * @author Kwok
 */
public class Test_GridLayout extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		Test_GridLayout gridLayoutFrame = new Test_GridLayout();
		gridLayoutFrame.setSize(800, 600);
		gridLayoutFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gridLayoutFrame.setLocationRelativeTo(null);
		gridLayoutFrame.setVisible(true);
		gridLayoutFrame.getContentPane().setLayout(new GridLayout(8, 2, 10, 20));
		gridLayoutFrame.add(new JButton("按钮1"));
		gridLayoutFrame.add(new JButton("按钮2"));
		gridLayoutFrame.add(new JButton("按钮3"));
		gridLayoutFrame.add(new JButton("按钮4"));
		gridLayoutFrame.add(new JButton("按钮5"));
		gridLayoutFrame.add(new JButton("按钮6"));
		gridLayoutFrame.add(new JButton("按钮7"));
		gridLayoutFrame.add(new JButton("按钮8"));
		gridLayoutFrame.add(new JButton("按钮9"));
		gridLayoutFrame.add(new JButton("按钮10"));
		gridLayoutFrame.add(new JButton("按钮11"));
		gridLayoutFrame.add(new JButton("按钮12"));
		gridLayoutFrame.add(new JButton("按钮13"));
		gridLayoutFrame.add(new JButton("按钮14"));
		gridLayoutFrame.add(new JButton("按钮15"));
		gridLayoutFrame.add(new JButton("按钮16"));
		
		gridLayoutFrame.validate();	//验证此容器及其所有子组件，再次布置其子组件。
		//gridLayoutFrame.pack();	//调整此窗口的大小，以适合其子组件的首选大小和布局。
		
	}

}
