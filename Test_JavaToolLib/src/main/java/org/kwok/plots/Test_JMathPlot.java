package org.kwok.plots;

import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.math.plot.Plot2DPanel;

/**
 * 
 * 类库：com.github.yannrichet:JMathPlot
 * 源码：https://github.com/yannrichet/jmathplot
 * 
 * @author Kwok
 * 2022-09-07
 */
public class Test_JMathPlot {

	public static void main(String[] args) throws Exception {

		double[] x = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		double[] y = new double[] { 2, 4, 8, 16, 32, 64, 128, 256, 512 };

		// create your PlotPanel (you can use it as a JPanel)
		Plot2DPanel plot = new Plot2DPanel();

		// add a line plot to the PlotPanel
		plot.addLinePlot("my plot", Color.red, x, y);

		plot.setAxisLabels("X", "Y");
		
		// 不显示刻度值
		// plot.getAxis(0).setLightLabelText(new String[] { "" });
		plot.getAxis(1).setLightLabelText(new String[] { "" });
		
		
		// put the PlotPanel in a JFrame, as a JPanel
		JFrame frame = new JFrame("a plot panel");
		
		frame.setContentPane(plot);
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// 写图表前，生成图表等待时间
		Thread.sleep(2000);
		// 写到图表到文件
		plot.toGraphicFile(new File("/opt/test.png"));
		// 销毁 JFrame 窗口
		frame.dispose();
		
	}

}
