package org.kwok.stopwatch;

import cn.hutool.core.date.StopWatch;

/**
 * Hutool Lib StopWatch.
 * 可分步 tag ，统计时间单位为纳秒，不太直观。
 * @author Kwok
 * 2022-06-09
 */
public class Test_StopWatch_Hutool {

	public static void main(String[] args) throws Exception {

		StopWatch sw = StopWatch.create("123");
		sw.start("1");
		Thread.sleep(1000);
		sw.stop();
		
		sw.start("2");
		Thread.sleep(2000);
		sw.stop();
		
		sw.start("3");
		Thread.sleep(2000);
		sw.stop();

		System.out.println(sw.getTotalTimeMillis());

		//统计结果 纳秒表示 不是太友善
		System.out.println(sw.prettyPrint());
	}

}
