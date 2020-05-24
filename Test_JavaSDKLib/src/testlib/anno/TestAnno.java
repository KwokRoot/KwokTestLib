package testlib.anno;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 该练习是对注解 应用 及 原理 的练习。
 * UseAnno 类 使用了 自定义注解。
 * TestAnno 类 加载  UseAnno 类 及 获得自定义注解的参数。
 * @author Kwok
 */
public class TestAnno {
	public static void main(String[] args) throws ClassNotFoundException {

		Class<?> c = Class.forName("testlib.anno.UseAnno");
		
		System.out.println("********* 类注解 *********");
		
		boolean flag = c.isAnnotationPresent(A.class);
		if (flag) {
			A a = (A) c.getAnnotation(A.class);
			System.out.println("A Annotation value	:" + a.value());
			System.out.println("A Annotation value1	:" + a.value1()[0]+","+ a.value1()[1]);
		} else {
			System.out.println("flag:" + flag);
		}
		
		
		System.out.println("********* 字段注解 *********");
		
		/* 访问所有字段 */
		Field[] fieldList = c.getDeclaredFields();
		for (Field f : fieldList) {
			if (f == null) {
				continue;
			}
			B b = f.getAnnotation(B.class);
			System.out.println("B Annotation value	: " + b.value());
		}
		
		
		System.out.println("********* 方法注解 *********");

		/* 访问所有方法 */
		Method[] methodlist = c.getMethods();
		for (Method m : methodlist) {
			C cm = m.getAnnotation(C.class);
			if (cm == null) {
				continue;
			}
			System.out.println("C Annotation("+m.getName()+"):  \nvalue1:" + cm.value1() + "\nvalue2:" + cm.value2());
		}

	}
	
}
