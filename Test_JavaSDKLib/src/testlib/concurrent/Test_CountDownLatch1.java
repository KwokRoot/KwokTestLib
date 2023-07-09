package testlib.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用方式一：让单个线程等待，多个线程(任务)完成后，进行汇总合并。
 * 示例描述：工厂中，质检，5个工人检查，所有人都认为通过，才通过。
 * @author Kwok
 * 2023-07-09
 */
public class Test_CountDownLatch1 {

    public static void main(String[] args) throws InterruptedException {
        
    	CountDownLatch latch = new CountDownLatch(5);
        
        ExecutorService service = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) {
        	
            final int no = i + 1;
            
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + no + "完成了检查。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            };
            
            service.submit(runnable);
        }
        
        System.out.println("等待5个人检查完.....");
        latch.await();
        System.out.println("所有人都完成了工作，进入下一个环节。");
        
        //关闭线程池
        service.shutdown();
    }
}
