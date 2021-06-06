package testlib.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * 该练习是对 java.awt.Robot 类的练习，使用 Java 也可做一些屏幕自动化的操作。
 * @author Kwok 
 * 2021-06-06
 */
public class Test_Robot {

	// Windows 显示 -> 缩放值(125%)
	public static final double factor = 1.25;

	public static void main(String[] args) throws AWTException {

		Robot robot = new Robot();

		// 定位到 Windows 窗口隐藏按键，多移动几次，一次可能不能定位到准确的目标位置。
		for (int i = 0; i < 3; i++) {
			// 是否需要乘以显示器缩放系数 factor，具体使用时要测试。测试时，Oracle JDK1.8 需要乘以该因子，而 OpenJDK15 不需要，相对来说可能与采集坐标的工具有关系！
			robot.mouseMove(Double.valueOf(1416 * factor).intValue(), Double.valueOf(10 * factor).intValue());
			// robot.mouseMove(Double.valueOf(1416).intValue(), Double.valueOf(10).intValue());
		}

		// 鼠标左键点击事件
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		
		//等待 10s 进行下一步操作。
		robot.delay(10000);
		
		
		//定位到 Windows 右下角时间项。
		for (int i = 0; i < 3; i++) {
			robot.mouseMove(Double.valueOf(1452 * factor).intValue(), Double.valueOf(845 * factor).intValue());
		}
		
		// 鼠标右键点击事件
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		
	}
}
