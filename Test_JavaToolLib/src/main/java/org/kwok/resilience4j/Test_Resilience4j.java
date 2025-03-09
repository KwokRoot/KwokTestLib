package org.kwok.resilience4j;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.netty.handler.timeout.TimeoutException;
import io.vavr.control.Try;

/**
 * Resilience4j 官方综合使用示例
 * @author Kwok
 * 2025-03-09
 */
public class Test_Resilience4j {

	public static class BackendService {
		
		public String doSomething() {
			System.out.println("doSomething 被调用");
			int i = 1/0;
			return "Hello World.";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BackendService backendService = new BackendService();
		
		// Create a CircuitBreaker with default configuration
		CircuitBreaker circuitBreaker = CircuitBreaker
		  .ofDefaults("backendService");

		// Create a Retry with default configuration
		// 3 retry attempts and a fixed time interval between retries of 500ms
		Retry retry = Retry
		  .ofDefaults("backendService");

		// Create a Bulkhead with default configuration
		Bulkhead bulkhead = Bulkhead
		  .ofDefaults("backendService");

		Supplier<String> supplier = () -> backendService.doSomething();

		// Decorate your call to backendService.doSomething() 
		// with a Bulkhead, CircuitBreaker and Retry
		// **note: you will need the resilience4j-all dependency for this
		Supplier<String> decoratedSupplier = Decorators.ofSupplier(supplier)
		  .withCircuitBreaker(circuitBreaker)
		  .withBulkhead(bulkhead)
		  .withRetry(retry)  
		  .decorate();

		// Execute the decorated supplier and recover from any exception
		String result = Try.ofSupplier(decoratedSupplier)
		  .recover(throwable -> "Hello from Recovery").get();
		System.out.println(result);
		
		// When you don't want to decorate your lambda expression,
		// but just execute it and protect the call by a CircuitBreaker.
		// 抛异常
//		String result2 = circuitBreaker
//		  .executeSupplier(backendService::doSomething);
//		System.out.println(result2);
		
		// You can also run the supplier asynchronously in a ThreadPoolBulkhead
		 ThreadPoolBulkhead threadPoolBulkhead = ThreadPoolBulkhead
		  .ofDefaults("backendService");

		// The Scheduler is needed to schedule a timeout 
		// on a non-blocking CompletableFuture
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		TimeLimiter timeLimiter = TimeLimiter.of(Duration.ofSeconds(1));

		CompletableFuture<String> future = Decorators.ofSupplier(supplier)
		    .withThreadPoolBulkhead(threadPoolBulkhead)
		    .withTimeLimiter(timeLimiter, scheduledExecutorService)
		    .withCircuitBreaker(circuitBreaker)
		    .withFallback(Arrays.asList(
		    		ArithmeticException.class,
		    		TimeoutException.class, 
		            CallNotPermittedException.class, 
		            BulkheadFullException.class),  
		                  throwable -> "Hello from Recovery")
		    .get().toCompletableFuture();
		System.out.println(future.get());
		
		scheduledExecutorService.shutdown();
		threadPoolBulkhead.close();
		
	}
	
}
