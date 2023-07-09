package testlib.concurrent.classicexample;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 多线程累加
 * @author Kwok 2023-07-09
 */
public class MultiThreadCount implements Runnable {

	int a;
	AtomicInteger realA = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 50000; i++) {
//			synchronized (this) {
				a++;
//			}
			realA.incrementAndGet();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MultiThreadCount r = new MultiThreadCount();
		Thread thread1 = new Thread(r);
		Thread thread2 = new Thread(r);
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println(r.a);
		System.out.println(r.realA.get());
	}
	
}
