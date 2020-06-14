package testlib.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 1.该练习是对 LocalDateTime、 DateTimeFormatter 的练习。
 * 2.LocalDateTime 与 java.util.Date 的互转。
 * 3.LocalDateTime 与 DateTimeFormatter 线程安全性测试。
 * @author Kwok
 */
public class Test_LocalDateTime2 {

	public static void main(String[] args) {
		
		System.out.println("--------- LocalDateTime 时间格式 ---------");
		// LocalDateTime 时间格式
		System.out.println(LocalDateTime.now());
		
		
		System.out.println("--------- 时间 转 格式化字符串 ---------");	
		// 时间 转 格式化字符串
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String ldtStr = LocalDateTime.now(ZoneOffset.of("+8")).format(dtf);
		System.out.println(ldtStr);
		
		
		System.out.println("--------- 格式化字符串 转 时间 ---------");	
		// 格式化字符串 转 时间
		LocalDateTime dateTime = LocalDateTime.parse(ldtStr, dtf);
		System.out.println(dateTime);
		
		
		System.out.println("--------- 默认格式化字符串 转 时间 ---------");	
		//默认格式化字符串 转 时间
		System.out.println(LocalDateTime.parse("2018-08-08T20:00:00"));
		
		
		System.out.println("--------- LocalDateTime 转 Date ---------");	
		// LocalDateTime 转 Date
		System.out.println(Date.from(dateTime.toInstant(ZoneOffset.of("+8"))));
		
		
		System.out.println("--------- Date 转 LocalDateTime ---------");	
		// Date 转 LocalDateTime
		System.out.println(new Date().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime());
		
		
		/*
		System.out.println("--------- DateTimeFormatter 线程安全性测试 ---------");
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(LocalDateTime.now().format(dtf));
				}
			}).start();
		}
		
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(LocalDateTime.parse(ldtStr, dtf));
				}
			}).start();
		}
		*/
		
	}

}
