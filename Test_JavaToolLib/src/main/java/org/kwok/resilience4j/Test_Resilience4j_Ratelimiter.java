package org.kwok.resilience4j;

import java.time.Duration;
import java.time.LocalDateTime;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;

/**
 * Resilience4j-Ratelimiter 示例
 * @author Kwok
 * 2025-03-09
 */
public class Test_Resilience4j_Ratelimiter {

	static RateLimiter rateLimiter;
	
	public static void init() {
		RateLimiterConfig config = RateLimiterConfig
				.custom()
				.limitRefreshPeriod(Duration.ofSeconds(1))   // 每秒刷新限流
		        .limitForPeriod(5)                           // 每秒允许的最大请求数
		        .timeoutDuration(Duration.ofMillis(0))       // 获取 permission 的最大等待时间，200ms
		        .build();
		
		RateLimiterRegistry registry = RateLimiterRegistry.of(config);
		rateLimiter = registry.rateLimiter("myRateLimiter");
	}
	
	static {
		init();
	}
	
	public static void test1() {
		for (int i = 0; i < 30; i++) {
			// 不阻塞
			if(rateLimiter.acquirePermission()) {
				new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	
	                    System.out.println(String.format("%-9s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠开始");
	                    try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	                    System.out.println(String.format("%-9s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 休眠结束");
	                }
	            }).start();
			}else {
				System.out.println("发生了限流");
			}
		}
	}
	
	
	public static void test2() {
		for (int i = 0; i < 30; i++) {
			try {
				// 不阻塞
				rateLimiter.executeRunnable(new Runnable() {
                @Override
                public void run() {
                	
                    System.out.println(String.format("%-9s ", Thread.currentThread().getName()) + LocalDateTime.now() + " 执行");
                    
                }
            });
			}catch (RequestNotPermitted e) {
				System.out.println("发生了限流");
			}
		}
	}
	
	public static void main(String[] args) {
		test1();
//		test2();
	}

}
