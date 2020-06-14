package testlib.gui.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 自定义选择对话框
 * @author Kwok
 */
public class Test_OptionDialog {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
	    
	    Object[] options = { "A", "B", "C", "D" };
	    int result = JOptionPane.showOptionDialog(jFrame, "message", "title", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
	    System.out.println(result);
	    
	}
}
