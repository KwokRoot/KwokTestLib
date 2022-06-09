package org.kwok.stopwatch;

import org.apache.commons.lang3.time.StopWatch;

/**
 * CommonsLang3 Lib StopWatch.
 * 功能简洁，没有分步 tag 功能。
 * @author Kwok
 * 2022-06-09
 */
public class Test_StopWatch_CommonsLang3 {

	public static void main(String[] args) throws Exception {

		StopWatch sw = new StopWatch();
		sw.start();
		Thread.sleep(1000);
		System.out.println(sw.getTime());
		Thread.sleep(2000);
		System.out.println(sw.getTime());
		sw.stop();
		System.out.println(sw.getTime());
		
	}

}
