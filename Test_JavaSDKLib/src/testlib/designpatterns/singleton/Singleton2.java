package testlib.designpatterns.singleton;


/**
 * 懒汉模式
 * 优点：延迟加载
 * 缺点：非线程安全
 * @author Kwok
 * 2023-07-09
 */
public class Singleton2 {

	private volatile static Singleton2 instance;

	private Singleton2() {}

	public static Singleton2 getInstance() {
		if (instance == null) {
			synchronized (Singleton2.class) {
				if (instance == null) {
					instance = new Singleton2();
					//do Something
				}
			}
		}
		return instance;
	}
}
