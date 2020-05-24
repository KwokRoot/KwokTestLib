package testlib.modifier.sub;

import testlib.modifier.Class_1;

/**
 * 不同包子类
 * @author Kwok
 */
public class Class_2_1 extends Class_1 {
	
	public static void main(String[] args) {

		System.out.println(new Class_1().a);
		
		// protected 修饰的属性 只能被自身，子类及同一个包中类 访问 。
		// 注：该方式编译错误！
		//System.out.println(new Class_1().b);
		// 注：该方式编译通过！protected 修饰的属性能被子类访问 。
		System.out.println(new Class_2_1().b);
		
		// 编译错误！ default（默认）修饰的属性只能在同一包中的类可以访问 。
		//System.out.println(new Class_2_1().c);

		// 编译错误！ private 修饰的属性只能在自身的方法中使用。
		//System.out.println(new Class_2_1().d);
	}

}
