package testlib.gui.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 自定义输入对话框
 * @author Kwok
 */
public class Test_OptionInputDialog {

	public static void main(String[] args) {
		
		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
	    
	    Object[] possibleValues = { "First", "Second", "Third" };
	    Object selectedValue = JOptionPane.showInputDialog(jFrame, "message", "title", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[1]);
	    System.out.println(selectedValue);
	    
	}
}
