package testlib.gui.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 内部选择对话框
 * @author Kwok
 */
public class Test_InternalConfirmDialog {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
	    
	    int result = JOptionPane.showInternalConfirmDialog(jFrame.getContentPane(), "message", "title", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	    System.out.println(result);
	    result = JOptionPane.showInternalConfirmDialog(jFrame.getContentPane(), "message", "title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    System.out.println(result);
	    
	}
}
