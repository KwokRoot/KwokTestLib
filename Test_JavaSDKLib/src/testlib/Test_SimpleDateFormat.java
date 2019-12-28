package testlib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * 1.验证 java.text.SimpleDateFormat 多线程下不安全。
 * 2.给出 java.text.SimpleDateFormat 在多线程下解决方案。
 * 3.java.util.Date 可变性解释。
 * 4.java.time.LocalDateTime 不可变性解释。
 * 5.java.util.Date 与 java.time.LocalDateTime 互转。
 * @author Kwok
 */
public class Test_SimpleDateFormat {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//SimpleDateFormat 在多线程场景下建议使用 ThreadLocal 方式获取。
	/*
	static ThreadLocal<SimpleDateFormat> sdfThreadLocal = new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	*/
	
	public static void main(String[] args) {
		
		String dateStr = "2019-06-28 12:12:30";
		
		//单线程测试：没问题
		/*
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(sdf.parse(dateStr));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		
		//多线程下测试
		/*
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(sdf.parse(dateStr));
						//System.out.println(sdfThreadLocal.get().parse(dateStr));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		*/
		
		
		System.out.println("--- java.time.LocalDateTime, This class is immutable(不可变的) and thread-safe ---");
		
		//jdk8 推荐线程安全的 LocalDateTime(java.time.LocalDateTime 不可变性)。
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		//设置 localDateTime 后返回一个新的 LocalDateTime 实例。
		LocalDateTime dt = localDateTime.with(ChronoField.DAY_OF_MONTH, 8);
		
		//设置 localDateTime 后，原 localDateTime 不会改变。
		System.out.println(localDateTime);
		System.out.println(dt);
		
		//为什么要淘汰 Date(java.util.Date 可变性)。
		Date date = new Date();
		System.out.println(date);
		date.setDate(8);
		System.out.println(date);
		
		
		System.out.println("--- 通过 java.time.Instant 实例为桥梁，实现 Date 与 LocalDateTime 互转 ---");
		
		//Date -> LocalDateTime
		System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneOffset.of("+8")));
		
		//LocalDateTime -> Date
		System.out.println(new Date(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()));
		
	}
	
}
