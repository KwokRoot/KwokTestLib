package testlib.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 使用方式二：让多个线程等待，模拟并发，让并发线程一起执行。
 * 示例描述：模拟100米跑步，5名选手都准备好了，只等裁判员一声令下，所有人同时开始跑步。
 * @author Kwok
 * 2023-07-09
 */
public class Test_CountDownLatch2 {
	
    public static void main(String[] args) throws InterruptedException {
    	
        CountDownLatch begin = new CountDownLatch(1);
        
        ExecutorService service = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) {
        	
            final int no = i + 1;
            
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + no + "准备完毕，等待发令枪");
                    try {
                        begin.await();
                        System.out.println("No." + no + "开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            
            service.submit(runnable);
        }
        
        //裁判员检查发令枪...
        Thread.sleep(5000);
        System.out.println("发令枪响，比赛开始！");
        begin.countDown();
        
        //关闭线程池
        service.shutdown();
    }
}
