package testlib.base;

import java.util.Collections;

/**
 * instanceof 判断 左边的对象 是否为 右边类或者子类 的实例。
 * 子类实例也是其父类、祖先类、及 Object 类的实例。
 * @author Kwok
 * 2022-06-09
 */
public class Test_instanceof {

	public static void main(String[] args) {
		
		System.out.println(new D() instanceof A);
		System.out.println(new D() instanceof B);
		System.out.println(new D() instanceof C);
		System.out.println(new D() instanceof D);
		System.out.println(new D() instanceof Object);
		
		System.out.println(new C() instanceof D);
		
		/*
		 * 声明对象时并没有创建对象。
		 */
		D d = null;
		System.out.println(d instanceof Object);
		
		/*
		结果：
		true
		true
		true
		true
		true
		false
		false
		*/
		
		
		
		System.out.println("例2 >>>" + String.join("", Collections.nCopies(2, "===")));
				
		Integer i = (Integer) null;
		System.out.println(i instanceof Integer);
		
		Integer j = new Integer(1);
		System.out.println(j instanceof Integer);
		System.out.println(j instanceof Number);
		
		/*
		结果：
		false
		true
		true
		*/
		
	}

}


class A {

}

class B extends A {

}

class C extends B {

}

class D extends C {

}
