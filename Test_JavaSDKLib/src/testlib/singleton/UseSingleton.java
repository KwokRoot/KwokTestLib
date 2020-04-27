package testlib.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试单例在多线程条件下线程的安全性。
 * 
 * @author Kwok
 */
public class UseSingleton {

	public static void main(String[] args) {

		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

		System.out.println("Singleton1:" + Singleton1.getInstance().hashCode());
		System.out.println("Singleton2:" + Singleton2.getInstance().hashCode());
		System.out.println("Singleton3:" + Singleton3.getInstance().hashCode());
		System.out.println("Singleton4:" + Singleton4.INSTANCE.hashCode());

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < 1000; i++) {
			newCachedThreadPool.execute(() -> {
				set.add(Singleton1.getInstance().hashCode());
				set.add(Singleton2.getInstance().hashCode());
				set.add(Singleton3.getInstance().hashCode());
				set.add(Singleton4.INSTANCE.hashCode());
			});
		}

		System.out.println(set.size());
		System.out.println(set);

		newCachedThreadPool.shutdown();

	}

}
