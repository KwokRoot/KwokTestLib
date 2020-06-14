package testlib.gui.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 该练习是对 BorderLayout 边框布局的练习。
 * @author Kwok
 */
public class Test_BorderLayout extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		Test_BorderLayout borderLayoutFrame = new Test_BorderLayout();
		borderLayoutFrame.setSize(800, 600);
		borderLayoutFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		borderLayoutFrame.setVisible(true);
		borderLayoutFrame.getContentPane().setLayout(new BorderLayout(10, 20));
		borderLayoutFrame.add(new JButton("按钮1"), BorderLayout.NORTH);
		borderLayoutFrame.add(new JButton("按钮2"), BorderLayout.SOUTH);
		borderLayoutFrame.add(new JButton("按钮3"), BorderLayout.EAST);
		borderLayoutFrame.add(new JButton("按钮4"), BorderLayout.WEST);
		borderLayoutFrame.add(new JButton("按钮5"), BorderLayout.CENTER);
		borderLayoutFrame.add(new JButton("按钮6"));
		
		borderLayoutFrame.validate();	//验证此容器及其所有子组件，再次布置其子组件。
		//borderLayoutFrame.pack();	//调整此窗口的大小，以适合其子组件的首选大小和布局。
		
	}
}