package testlib.base;

/**
 * 子类也是父类、祖先类、及 Object 类的实例。
 * @author Kwok
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
