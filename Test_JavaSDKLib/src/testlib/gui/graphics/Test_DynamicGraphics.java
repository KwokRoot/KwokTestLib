package testlib.gui.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 重写 java.awt.Window.paint(Graphics paramGraphics) 方法自定义窗口的动态效果。
 * @author Kwok
 */
public class Test_DynamicGraphics {

	public static void main(String[] args) throws Exception {

		MyFream2 myFream = new MyFream2();
		MyPanel2 myPanel = new MyPanel2();
		myFream.add(myPanel);
		for (int i = 0; i < 100; i++) {
			myPanel.repaint();
			Thread.sleep(100);
		}
		
	}

}

class MyFream2 extends JFrame {

	private static final long serialVersionUID = 1L;

	{
		this.setVisible(true);
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

class MyPanel2 extends JPanel {

	private static final long serialVersionUID = 1L;

	int i;
	int j;
	
	@Override
	public void paint(Graphics g) {
		System.out.println("已调用-paint" + i + "次");
		super.paint(g);
		g.setColor(Color.blue);
		g.drawLine(0, 0, i++, j++);
	}
	
}