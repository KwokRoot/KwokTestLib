package testlib.concurrent.classicexample;


/**
 * 多线程打印奇偶-使用wait()/notify()方法
 * @author Kwok
 * 2023-07-09
 */
public class MultiThreadPrintOddEven2 {
	
	private static int count = 0;

	private final static Object lock = new Object();

	public static void main(String[] args) {
		new Thread(new TurningRunner(), "偶数").start();
		new Thread(new TurningRunner(), "奇数").start();
	}

	static class TurningRunner implements Runnable {
		@Override
		public void run() {
			while (count <= 100) {
				synchronized (lock) {
					System.out.println(Thread.currentThread().getName() + ":" + count++);
					// 如果任务没结束，唤醒其他线程，自己休眠
					lock.notify();
					if (count <= 100) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
