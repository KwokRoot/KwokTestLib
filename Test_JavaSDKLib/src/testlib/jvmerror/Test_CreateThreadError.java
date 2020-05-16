package testlib.jvmerror;

import java.util.concurrent.atomic.AtomicLong;

/*
 * 该测试 没有 出现异常： java.lang.OutOfMemoryError: unable to create new native thread。
 * 谨慎测试。操作系统内存会不断升高，造成操作系统卡死，需要提前强制结束程序。
 */
public class Test_CreateThreadError {

	static AtomicLong count = new AtomicLong();

	public static void main(String[] args) throws Exception {

		while (true) {

			new Thread(new Runnable() {
				@Override
				public void run() {

					System.out.println(count.incrementAndGet());

					try {
						Thread.sleep(600000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();

			Thread.sleep(1);

		}
	}

}
