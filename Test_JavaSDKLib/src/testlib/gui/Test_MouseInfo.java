package testlib.gui;

import java.awt.MouseInfo;

/**
 * java.awt.MouseInfo 类能够获取鼠标相关的信息。
 * @author Kwok
 * 2022-05-15
 */
public class Test_MouseInfo {

	public static void main(String[] args) {
		
		// 获取光标的当前位置。
		System.out.println(MouseInfo.getPointerInfo().getLocation());

		//获取单个坐标点 int 类型。
		System.out.println(MouseInfo.getPointerInfo().getLocation().x);
		
		//获取单个坐标点 double 类型。
		System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
		
	}

}
