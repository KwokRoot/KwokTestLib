package testlib.innerclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 该练习主要是对内部类、匿名内部类、构造方法中的匿名内部类、普通方法中的匿名内部类了解的练习。
 * 了解 Class.getEnclosingClass() 、 Class.getEnclosingConstructor() 、 Class.getEnclosingMethod() 的方法。
 * @author Kwok
 */
public class Outer {
	
	// 内部类
	public static class InnerClass {
		public InnerClass() {
			
		}
		
		public void fun() {
			
		}
	}
		
		
	// 匿名内部类
	static InnerClass innerClass = new InnerClass() {
		public void fun() {
			System.out.println(this);
			getEnclosing(this.getClass());
			/**
			 * enclosingClass=class testlib.innerclass.Outer
			 * enclosingConstructor=null
			 * enclosingMethod=null
			 */
		};
	};
		
	
	public Outer() {
		// 构造方法中的匿名内部类
		InnerClass innerClass = new InnerClass() {
			@Override
			public void fun() {
				System.out.println(this);
				getEnclosing(this.getClass());
				/**
				 * enclosingClass=class testlib.innerclass.Outer
				 * enclosingConstructor=public testlib.innerclass.Outer()
				 * enclosingMethod=null
				 */
			}
		};
		innerClass.fun();
	}
	
	
	public static void test() {
		// 方法中的匿名内部类
		InnerClass innerClass = new InnerClass() {
			@Override
			public void fun() {
				System.out.println(this);
				getEnclosing(this.getClass());
				/**
				 * enclosingClass=class testlib.innerclass.Outer
				 * enclosingConstructor=null
				 * enclosingMethod=public static void testlib.innerclass.Outer.test()
				 */

			}
		};
		innerClass.fun();
	}
		
		
		/**
		 * getEnclosingClass:该类是在哪个类中定义的， 比如直接定义的内部类或匿名内部类
		 * getEnclosingConstructor：该类是在哪个构造函数中定义的，比如构造方法中定义的匿名内部类
		 * getEnclosingMethod：该类是在哪个方法中定义的，比如方法中定义的匿名内部类
		 * 
		 * @param cls
		 */
		private static void getEnclosing(Class<?> cls) {
			
			Class<?> enclosingClass = cls.getEnclosingClass();
			System.out.println("enclosingClass=" + enclosingClass);
			
			Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
			System.out.println("enclosingConstructor=" + enclosingConstructor);
			
			Method enclosingMethod = cls.getEnclosingMethod();
			System.out.println("enclosingMethod=" + enclosingMethod);

		}

		
		public static void main(String[] args) {
			
			System.out.println("------内部类------");
			System.out.println(InnerClass.class.getName());
			getEnclosing(InnerClass.class);
			
			System.out.println("------匿名内部类------");
			innerClass.fun();
			
			System.out.println("------构造函数中的匿名内部类------");
			new Outer();
			
			System.out.println("------方法中的匿名内部类------");
			Outer.test();
			
		}
		
}
