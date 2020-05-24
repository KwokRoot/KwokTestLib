package testlib.modifier;

import testlib.modifier.Class_1;

/**
 * 同包类
 * @author Kwok
 */
public class Class_3 {

	public static void main(String[] args) {
		
		System.out.println(new Class_1().a);
		
		System.out.println(new Class_1().b);
		
		System.out.println(new Class_1().c);
		
		// 编译错误！private 修饰的属性只能在自身的方法中使用。
		// System.out.println(new Class_1().d);
	}

}
