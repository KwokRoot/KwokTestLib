package org.kwok.resilience4j;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.kwok.CommonUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * 重试：resilience4j-retry
 * https://github.com/resilience4j/resilience4j
 * @author Kwok
 * 2025-04-20
 */
public class Test_Resilience4j_Retry {

	static int i = 0;
	
	public static void main(String[] args) {
		
		RetryConfig config = RetryConfig.custom()
			    .waitDuration(Duration.ofMillis(100))
			    .retryOnException(e -> e instanceof IOException)
			    .retryExceptions(RuntimeException.class)
			    .ignoreExceptions()
			    .retryOnResult(r -> null == r || Objects.equals(r, false))
			    // .waitDuration(Duration.ofSeconds(1))  //固定间隔
				// .intervalFunction(IntervalFunction.ofRandomized(Duration.ofMillis(1000)))  //随机间隔
				.intervalFunction(IntervalFunction.ofExponentialBackoff(Duration.ofMillis(1000), 2, Duration.ofSeconds(10))) //指数间隔
				.maxAttempts(6)
				.build();
			    
			// Create a RetryRegistry with a custom global configuration
			RetryRegistry registry = RetryRegistry.of(config);
			
			Retry retry = registry.retry("default");
			retry.getEventPublisher().onRetry(event -> {
				System.out.println(CommonUtils.datetime() + " 重试 " + event.getNumberOfRetryAttempts() + " 次：" + event);
			});
			
			try {
				Boolean executeCallable = retry.executeCallable(new MyCallable());
				System.out.println(executeCallable);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
	}

	
	static class MyCallable implements Callable<Boolean> {

		@Override
	    public Boolean call() throws Exception {
	    	System.out.println(CommonUtils.datetime() + " 调用 " + ++i + " 次");
    		if (i == 1) {
    			return null;
    		}
    		
    		if (i == 2) {
    			throw new IOException("io");
    		}

    		if (i == 3) {
    			throw new RuntimeException("test");
    		}
			
    		if (i == 4) {
    			return false;
    		}
    		
	        return true;
	    }
	
	}
	
}
