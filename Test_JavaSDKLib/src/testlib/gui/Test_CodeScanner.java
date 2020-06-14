package testlib.gui;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * 该练习是对扫描设备的测试练习。
 * 结果：扫码枪在扫描字符串后默认加换行键（即键码是10）。
 * @author Kwok
 */
public class Test_CodeScanner {

	public static void main(String[] args) {
		
		System.out.println("键码为10键：" + KeyEvent.getKeyText(10));
		
		JFrame jFrame = new JFrame("扫码枪测试");
		jFrame.setSize(900, 300);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final Label label = new Label(null, Label.CENTER);
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setSize(10,10);
		jFrame.add(label);
		
		jFrame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				//System.out.print(e.getKeyCode() + " : " + e.getKeyChar() + " , ");
				//label.setText(e.getKeyCode() + " : " + e.getKeyChar());
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

				System.out.print(e.getKeyCode() + " : " + e.getKeyChar() + " , ");
				label.setText(e.getKeyCode() + " : " + e.getKeyChar());
				
			}
		});
		
	}

}
