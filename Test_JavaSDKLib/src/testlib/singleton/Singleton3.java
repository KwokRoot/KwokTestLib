package testlib.singleton;

//静态类内部加载
public class Singleton3 {

	private static class SingletonHolder {
		private static Singleton3 instance = new Singleton3();
	}

	private Singleton3() {
	}

	public static Singleton3 getInstance() {
		return SingletonHolder.instance;
	}

}
