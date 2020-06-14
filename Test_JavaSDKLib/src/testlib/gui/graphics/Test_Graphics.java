package testlib.gui.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 重写 java.awt.Window.paint(Graphics paramGraphics) 方法自定义窗口的样式。
 * @author Kwok
 */
public class Test_Graphics {

	public static void main(String[] args) {

		MyFream myFream = new MyFream();
		MyPanel myPanel = new MyPanel();
		myFream.add(myPanel);
		
	}

}

class MyFream extends JFrame {

	private static final long serialVersionUID = 1L;

	{
		this.setVisible(true);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("已调用-paint1");
		super.paint(g);
		g.setColor(Color.red);
		g.drawLine(0, 0, 60, 60);
	}

}

class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		System.out.println("已调用-paint2");
		super.paint(g);
		g.setColor(Color.blue);
		g.drawLine(0, 0, 60, 60);
	}
}