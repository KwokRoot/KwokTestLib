package testlib.concurrent.classicexample;


/**
 * 多线程打印奇偶-使用synchronized关键字
 * @author Kwok
 * 2023-07-09
 */
public class MultiThreadPrintOddEven1 {

	private static int count;

	private final static Object lock = new Object();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (count < 100) {
					synchronized (lock) {
						System.out.println(Thread.currentThread().getName() + ": 抢到锁");
						if ((count & 1) == 0) {
							System.out.println(Thread.currentThread().getName() + ":" + count++);
						}
					}
				}
			}
		}, "偶数").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (count < 100) {
					synchronized (lock) {
						System.out.println(Thread.currentThread().getName() + ": 抢到锁");
						if ((count & 1) == 1) {
							System.out.println(Thread.currentThread().getName() + ":" + count++);
						}
					}
				}
			}
		}, "奇数").start();

	}
}
