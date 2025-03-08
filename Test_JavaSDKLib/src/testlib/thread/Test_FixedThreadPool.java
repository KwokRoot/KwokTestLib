package testlib.thread;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 固定线程池
 * @author Kwok
 * @date: 2025/3/4
 */
public class Test_FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(String.format("%-16s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠开始");
                        Thread.sleep(3000);
                        System.out.println(String.format("%-16s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
        boolean flag = true;
        while (true && flag){
            if(executorService.isTerminated()){
                Long endTime = System.currentTimeMillis();
                System.out.println(endTime - startTime);
                flag = false;
            }
        }

    }
}
