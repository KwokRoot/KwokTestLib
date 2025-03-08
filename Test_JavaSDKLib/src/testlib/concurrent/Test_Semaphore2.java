package testlib.concurrent;


import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

/**
 * @description: 限流
 * @author: Kwok
 * @date: 2025/3/4
 */
public class Test_Semaphore2 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5, true);

        for (int i = 0; i < 30; i++) {
        	
        	System.out.println(String.format("线程 %s 初始化完毕", i));
        	
        	new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(String.format("%-7s ", Thread.currentThread().getName()) + LocalDateTime.now() +  " 休眠开始");
                        try {
    						Thread.sleep(3000);
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
                        System.out.println(String.format("%-7s ", Thread.currentThread().getName()) + LocalDateTime.now() +  " 休眠结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }

                }
            }, "Test-" + i).start();
        }

        System.out.println("线程全部初始化完毕");

    }

}
