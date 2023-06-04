package testlib.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Test_Lock {

	private static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		
		new Thread(() -> exec()).start();
		new Thread(() -> exec()).start();
		
		System.out.println(Thread.currentThread().getName());
		
	}
	
	private static void exec() {
		
		// 注：放到 try 外
		lock.lock();

		try {

			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
}
