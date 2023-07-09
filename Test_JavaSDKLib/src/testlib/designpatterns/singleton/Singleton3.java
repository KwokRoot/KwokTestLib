package testlib.designpatterns.singleton;


/**
 * 静态类内部加载
 * @author Kwok
 * 2023-07-09
 */
public class Singleton3 {

	private Singleton3() {}

	private static class SingletonHolder {
		private final static Singleton3 INSTANCE = new Singleton3();
		static {
			//do Something
		}
	}
	
	public static Singleton3 getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
