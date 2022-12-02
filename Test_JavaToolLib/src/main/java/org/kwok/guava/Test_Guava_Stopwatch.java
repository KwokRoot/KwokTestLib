package org.kwok.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

/**
 * Guava.Stopwatch
 * @author Kwok
 * 2022-12-02
 */
public class Test_Guava_Stopwatch {

	public static void main(String[] args) throws Exception {
		
		Stopwatch sw = Stopwatch.createStarted();
		
		Thread.sleep(1000);
		System.out.println(sw.elapsed(TimeUnit.MILLISECONDS));

		Thread.sleep(1000);
		System.out.println(sw.elapsed(TimeUnit.MILLISECONDS));
		
		sw.reset().start();
		Thread.sleep(1000);
		System.out.println(sw.elapsed(TimeUnit.MILLISECONDS));

	}

}
