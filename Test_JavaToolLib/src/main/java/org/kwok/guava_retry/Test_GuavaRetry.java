package org.kwok.guava_retry;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.RetryListener;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicates;
import org.kwok.util.CommonUtils;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 重试：guava-retrying
 * https://github.com/rholder/guava-retrying
 * @author Kwok
 * 2025-04-20
 */
public class Test_GuavaRetry {

	static int i = 0;
	
	public static void main(String[] args) {	
		
		Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
				// 满足定义的断言 Predicates 才会 retry
		        .retryIfResult(Predicates.<Boolean>isNull())
		        .retryIfExceptionOfType(IOException.class)
		        .retryIfRuntimeException()
		        .retryIfResult(Predicates.equalTo(false))
		        // .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))  //固定间隔
				// .withWaitStrategy(WaitStrategies.randomWait(1, TimeUnit.SECONDS))  //随机间隔
				.withWaitStrategy(WaitStrategies.exponentialWait(1000, 3, TimeUnit.SECONDS))  //指数间隔
				.withStopStrategy(StopStrategies.stopAfterAttempt(5))
		        .withRetryListener(new MyRetryListener())
		        .build();
		
		try {
		    retryer.call(new MyCallable());
		} catch (RetryException e) {
		    e.printStackTrace();
		} catch (ExecutionException e) {
		    e.printStackTrace();
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
	
	static class MyRetryListener implements RetryListener {
		
		@Override
		public <Boolean> void onRetry(Attempt<Boolean> attempt) {
			
			String msg = null;
			if(attempt.hasResult()) {
				msg = "结果：" + attempt.getResult();
			}
			if(attempt.hasException()) {
				msg = "异常：" + attempt.getExceptionCause();
			}
			
			System.out.println(CommonUtils.datetime() + " 重试 " + attempt.getAttemptNumber() + " 次：" + msg);
			
		}
	}
	
}
