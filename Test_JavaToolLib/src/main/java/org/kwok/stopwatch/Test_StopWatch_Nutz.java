package org.kwok.stopwatch;

import org.nutz.lang.Stopwatch;

/**
 * Nutz Lib StopWatch(推荐).
 * 可分步 tag ，统计单位可选毫秒/纳秒，统计结果直观。
 * @author Kwok
 * 2022-06-09
 */
public class Test_StopWatch_Nutz {

	public static void main(String[] args) throws Exception {

		Stopwatch stopwatch = Stopwatch.begin();
		Thread.sleep(1000);
		stopwatch.tag("step[1]");
		Thread.sleep(2000);
		stopwatch.tag("step[2]");
		stopwatch.stop();
		System.out.println(stopwatch.getDuration());
		System.out.println(stopwatch);

	}

}
