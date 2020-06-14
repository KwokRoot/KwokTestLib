package testlib.gui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

/**
 * 该练习是对常用事件监听器的简单练习。
 * @author Kwok
 */
public class Test_Event {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		frame.addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowLostFocus(WindowEvent paramWindowEvent) {
				System.out.println(paramWindowEvent.getID());
				System.out.println(paramWindowEvent.getSource());
				System.out.println(paramWindowEvent.getWindow());
			}
			@Override
			public void windowGainedFocus(WindowEvent paramWindowEvent) {
				System.out.println(paramWindowEvent.getID());
				System.out.println(paramWindowEvent.getSource());
				System.out.println(paramWindowEvent.getWindow());
			}
		});
		
		
		TextField textField = new TextField();
		
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				System.out.println("ActionEvent");
			}
		});
		
		textField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keyTyped:" + e);
				System.out.println("keyTyped:" + e.getKeyCode()); //值为 0
				System.out.println("keyTyped:" + e.getKeyChar());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased:" + e);
				System.out.println("keyReleased:" + e.getKeyCode());
				System.out.println("keyReleased:" + e.getKeyChar());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed:" + e);
				System.out.println("keyPressed:" + e.getKeyCode());
				System.out.println("keyPressed:" + e.getKeyChar());
			}
		});
		
		textField.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent paramTextEvent) {
				System.out.println("textValueChanged:" + ((TextField)paramTextEvent.getSource()).getText());
			}
		});
		
		frame.add(textField);
		
	}

}
