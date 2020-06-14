package testlib.gui.JOptionPane;

import java.awt.Dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 对话框初始化步骤
 * @author Kwok
 */
public class Test_JOptionPane {

	public static void main(String[] args) {

		JFrame jFrame = new JFrame();
	    jFrame.setSize(600, 300);
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setVisible(true);
	    jFrame.setLocationRelativeTo(null);
		
		JOptionPane pane = new JOptionPane();
	    pane.setMessage("Hello");
	    
	    // ERROR_MESSAGE、INFORMATION_MESSAGE、WARNING_MESSAGE、QUESTION_MESSAGE、PLAIN_MESSAGE 
	    pane.setMessageType(JOptionPane.WARNING_MESSAGE);

	    //DEFAULT_OPTION、YES_NO_OPTION、YES_NO_CANCEL_OPTION、OK_CANCEL_OPTION 
	    pane.setOptionType(JOptionPane.YES_NO_CANCEL_OPTION);
	    
	    Dialog dialog = pane.createDialog(jFrame, "温馨提示：");
	    dialog.setVisible(true);
	    
	    System.out.println(pane.getValue());
	    
	    dialog.dispose();

	}

}
