package testlib.modifier;

/**
 * 同包子类
 * @author Kwok
 */
public class Class_2 extends Class_1 {
	
	public static void main(String[] args) {

		System.out.println(new Class_1().a);
		
		System.out.println(new Class_1().b);
		
		System.out.println(new Class_1().c);

		// 编译错误！private 修饰的属性只能在自身的方法中使用。
		//System.out.println(new Class_1().d);
	}

}
