package testlib.gui.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 输入对话框
 * @author Kwok
 */
public class Test_InputDialog {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
	    
	    String inputValue = JOptionPane.showInputDialog(jFrame, "message", "title", JOptionPane.ERROR_MESSAGE);
	    System.out.println(inputValue);
	    
	}
}
