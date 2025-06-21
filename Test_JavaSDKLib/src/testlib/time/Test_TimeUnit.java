package testlib.time;

import java.util.concurrent.TimeUnit;

/**
 * 时间转化 TimeUnit 枚举类
 * @author Kwok
 * 2025-06-14
 */
public class Test_TimeUnit {

	public static void main(String[] args) {
		
		// 小时 转 毫秒
		System.out.println(TimeUnit.HOURS.toMillis(1));
		System.out.println(TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS));
		
		// 天 转 毫秒
		System.out.println(TimeUnit.DAYS.toMillis(1));
		System.out.println(TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
		
		// 毫秒 转 天
		System.out.println(TimeUnit.MILLISECONDS.toDays(86400000));
		System.out.println(TimeUnit.DAYS.convert(86400000, TimeUnit.MILLISECONDS));
		
	}

}
