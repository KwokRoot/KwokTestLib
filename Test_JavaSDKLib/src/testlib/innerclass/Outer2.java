package testlib.innerclass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 该练习主要是对 Class 类部分方法的练习。
 * Class.getDeclaringClass() ;
 * Class.getDeclaredClasses() 、 Class.getDeclaredAnnotations() 、 Class.getDeclaredConstructors() 、 Class.getDeclaredFields() 、 Class.getDeclaredMethods() 等。
 * Class.getDeclaredConstructor(Class<?>... parameterTypes) 、 Class.getDeclaredField(String name) 、 Class.getDeclaredMethod(String name, Class<?>... parameterTypes) ;
 * @author Kwok
 */
@CustomAnnotation
public class Outer2 {
	
	// 内部类
	public static class InnerClass {
		public InnerClass() {

		}

		public void fun() {

		}
	}

	// 内部接口
	public interface InnerInterface {

	}

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		Class<?> declaringClass = InnerClass.class.getDeclaringClass();
		System.out.println("定义 InnerClass 所在的类为：" + declaringClass);  // class testlib.innerclass.Outer2

		declaringClass = InnerInterface.class.getDeclaringClass();
		System.out.println("定义 InnerInterface 所在的类为：" + declaringClass);  // class testlib.innerclass.Outer2
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		// 1.获取当前类中的所有类、接口、枚举、注解类等。 (不包括继承的)
		Class<?>[] declaredClasses = Outer2.class.getDeclaredClasses();
		System.out.println(Arrays.toString(declaredClasses));
		// 结果：[class testlib.innerclass.Outer2$InnerClass, interface testlib.innerclass.Outer2$InnerInterface]

		// 2.当前类上直接使用的注解 (不包括继承的)
		Annotation[] declaredAnnotations = Outer2.class.getDeclaredAnnotations();
		System.out.println(Arrays.toString(declaredAnnotations));
		// 结果：[@testlib.innerclass.CustomAnnotation()]
		
		// 3.当前类中的所有构造函数 (不包括继承的)
		Constructor<?>[] declaredConstructors = Outer2.class.getDeclaredConstructors();
		System.out.println(Arrays.toString(declaredConstructors));
		// 结果：[public testlib.innerclass.Outer2()]

		// 4.当前类中的所有成员变量 (不包括继承的)
		Field[] declaredFields = Outer2.class.getDeclaredFields();  //
		//Outer2.class.getDeclaredField(name)
		System.out.println(Arrays.toString(declaredFields));
		// 结果：[]
		
		// 5.当前类中的所有方法 (不包括继承的)
		Method[] declaredMethods = Outer2.class.getDeclaredMethods();
		// Outer2.class.getDeclaredMethod(name, parameterTypes)
		System.out.println(Arrays.toString(declaredMethods));
		// 结果：[public static void testlib.innerclass.Outer2.main(java.lang.String[])]
		
	}
	
}
