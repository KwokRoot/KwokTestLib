package testlib.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 调用者
 * 给定时间内获取被调用者的返回值，否则抛出 'TimeoutException'。
 * @author Kwok
 */
public class MainMethod {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return CalledMethod.execute();
			}
			
		});
		
		try {
			System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
			System.out.println("给定时间内获取到结果。");
		} catch (Exception e) {
			System.out.println("给定时间内没有获取到结果。");
			//e.printStackTrace();
			future.cancel(true); //超时中断正在运行的任务。
		}
		
		executorService.shutdown();

	}
}
