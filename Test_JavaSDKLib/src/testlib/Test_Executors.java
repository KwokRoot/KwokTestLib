package testlib;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 使用 java.util.concurrent.Executors 创建线程池
 * 实现 java.lang.Runnable && java.util.concurrent.Callable<V> 线程调用接口。
 * @author Kwok
 */
public class Test_Executors {

	public static void main(String[] args) throws TimeoutException {
		
		System.out.println(System.currentTimeMillis() + "- 开始 -" + Thread.currentThread().getName());
		
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newCachedThreadPool();
		//ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		
		Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println(System.currentTimeMillis() + "- 开始 -" + Thread.currentThread().getName());
				Thread.sleep(3000);
				System.out.println(System.currentTimeMillis() + "- 结束 -" + Thread.currentThread().getName());
				return "Hello World";
			}
		});
		
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis() + "- 开始 -" + Thread.currentThread().getName());
				try {
					Thread.sleep(3000);
					System.out.println(System.currentTimeMillis() + "- 结束 -" + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			if(future.get(10000, TimeUnit.MILLISECONDS) != null){
				System.out.println(System.currentTimeMillis() + "- 接收到返回值 - " + future.get() + " -" + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
		
		System.out.println(System.currentTimeMillis() + "- 结束 -" + Thread.currentThread().getName());
		
	}
	
}
