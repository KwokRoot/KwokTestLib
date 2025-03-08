package testlib.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 固定线程池错误使用示例
 * @author Kwok
 * @date: 2025/3/4
 */
public class Test_FixedThreadPool_ErrorCase {

    public static void main(String[] args) {

        // errCase01();
        errCase01_Optimize();

    }

    public static void errCase01(){

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        while (true){
            // 没有确定的任务数量，会一直提交执行任务到等待队列。
            System.err.println(executorService.getQueue().size());

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
    }

    public static void errCase01_Optimize() {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        while (true){
            // 通过控制线程等待队列数，防止内存溢出。
            if(executorService.getQueue().size() < 500){

                System.err.println(executorService.getQueue().size());

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
            }else {
                try {
                    // while(true) 最好加个休眠时间，防止 CPU 空转。
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
