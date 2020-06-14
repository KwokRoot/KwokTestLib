package testlib.gui.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 消息对话框
 * @author Kwok
 */
public class Test_MessageDialog {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
	    
	    JOptionPane.showMessageDialog(jFrame.getContentPane(), "message", "title", JOptionPane.INFORMATION_MESSAGE);
	    
	}
}
