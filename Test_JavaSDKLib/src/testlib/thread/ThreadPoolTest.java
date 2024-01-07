package testlib.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	private volatile static Map<String, Thread> threadName_Thread_Map = new ConcurrentHashMap<>();
	private volatile static Map<Thread, Boolean> thread_threadStstus_Map = new ConcurrentHashMap<>();
	

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = ThreadPoolUtil.getInstance();
		for (int i = 1; i <= 10; i++) {
			final int num = i;
			executor.execute(() -> {
				Thread.currentThread().setName("thread-" + num);
				threadName_Thread_Map.put("thread-" + num, Thread.currentThread());
				thread_threadStstus_Map.put(Thread.currentThread(), true);
				while(!Thread.interrupted() && thread_threadStstus_Map.getOrDefault(Thread.currentThread(), false)) {
					System.out.println(Thread.currentThread().getName() + "在运行...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.err.println("thread-" + num);
						e.printStackTrace();
		                break;
					}
				}
			});
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println(thread_threadStstus_Map.size());
		System.out.println(threadName_Thread_Map.size());
		
		for (int i = 1; i <= 10; i++) {
			
			try {
				Thread.sleep(1000);
				Thread thread = threadName_Thread_Map.get("thread-" + i);
				System.out.println(thread.getName() + ":" + thread.getState());
				thread.interrupt();
				// thread.stop();

				System.out.println("thread-" + i + " 线程已经中断...");
			} catch (Exception e) {
				System.err.println("thread-" + i);
				e.printStackTrace();
				thread_threadStstus_Map.put(threadName_Thread_Map.get("thread-" + i), false);
			}
			
		}

	}
	
	public static class ThreadPoolUtil{
		/**
	     * 线程池实例
	     */
	    private volatile static ThreadPoolExecutor instance = null;
		
		public static ThreadPoolExecutor getInstance() {
	        if (instance == null) {
	            synchronized (ThreadPoolUtil.class) {
	                if (instance == null) {
	                    // 初始化线程池
	                    instance = new ThreadPoolExecutor(10, 30, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000));
	                }
	            }
	        }
	        return instance;
	    }
	}
	
	
}
