package org.kwok.guava;

import java.time.LocalDateTime;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @description: RateLimiter 限流
 * @author Kwok
 * @date: 2025/3/4
 */
public class Test_Guava_RateLimiter {

    public static void main(String[] args) {

        RateLimiter limiter = RateLimiter.create(5);

        for (int i = 0; i < 30; i++) {
        	
        	System.out.println(String.format("线程 %s 初始化完毕", i));
        	
            new Thread(new Runnable() {
                @Override
                public void run() {
                    limiter.acquire();
                    System.out.println(String.format("%-7s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠开始");
                    try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                    System.out.println(String.format("%-7s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠结束");
                }
            }, "Test-" + i).start();
        }

        System.out.println("线程全部初始化完毕");

    }

}
