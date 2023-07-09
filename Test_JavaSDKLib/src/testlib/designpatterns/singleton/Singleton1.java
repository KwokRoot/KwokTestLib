package testlib.designpatterns.singleton;


/**
 * 饿汉模式
 * 优点：线程安全
 * 缺点：加载缓慢
 * @author Kwok
 * 2023-07-09
 */
public class Singleton1 {

	private final static Singleton1 INSTANCE = new Singleton1();

	static {
		//do Something
	}
	
	private Singleton1() {}

	public static Singleton1 getInstance() {
		return INSTANCE;
	}

}
