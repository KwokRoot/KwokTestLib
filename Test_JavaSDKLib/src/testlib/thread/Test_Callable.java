package testlib.thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 该练习是利用 Callable 接口、Future 接口实现 Java 多线程的练习。
 * @author Kwok
 */
public class Test_Callable {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		//ExecutorService executor = Executors.newFixedThreadPool(3);
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(new CallableImpl());
		Future<Integer> future2 = executor.submit(new CallableImpl());
		Future<Integer> future3 = executor.submit(new CallableImpl());
		
		
		System.out.println("--------- 多线程处理开始(线程池) ---------");
		System.out.println("当前时间：" + new Date().getTime());
		try {
			System.out.println(new Date().getTime() + ":" + future.get());
			System.out.println(new Date().getTime() + ":" + future2.get());
			System.out.println(new Date().getTime() + ":" + future3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.println("--------- 多线程处理完毕(线程池) ---------");
		
		
		System.out.println("--------- 单线程处理开始 ---------");
		System.out.println("当前时间：" + new Date().getTime());
		try {
			System.out.println(new Date().getTime() + ":" + new CallableImpl().call());
			System.out.println(new Date().getTime() + ":" + new CallableImpl().call());
			System.out.println(new Date().getTime() + ":" + new CallableImpl().call());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------- 单线程处理完毕 ---------");
		
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableImpl());
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new CallableImpl());
		FutureTask<Integer> futureTask3 = new FutureTask<Integer>(new CallableImpl());
		System.out.println("--------- 多线程处理开始 ---------");
		System.out.println("当前时间：" + new Date().getTime());
		try {
			new Thread(futureTask).start();
			new Thread(futureTask2).start();
			new Thread(futureTask3).start();
			System.out.println(new Date().getTime() + ":" + futureTask.get());
			System.out.println(new Date().getTime() + ":" + futureTask2.get());
			System.out.println(new Date().getTime() + ":" + futureTask3.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("--------- 多线程处理完毕 ---------");
	}

}


class CallableImpl implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			Thread.sleep(300);
			sum += i;
		}
		
		return sum;
	}
	
}