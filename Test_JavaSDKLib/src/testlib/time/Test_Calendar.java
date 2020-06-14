package testlib.time;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 该练习是对 java.util.Calendar 简单的练习。
 * Calendar 类能对日期进行加减操作。
 * @author Kwok
 */
public class Test_Calendar {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1：简单的日期加减 ------------------------------");
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
		calendar.add(Calendar.MILLISECOND, 3);
		System.out.println(calendar.getTimeInMillis());
		calendar.add(Calendar.MILLISECOND, -3);
		System.out.println(calendar.getTimeInMillis());
		
		
		System.out.println("------------------------------ 操作 2：Calendar 设置时区 ------------------------------");
		
		Calendar calendar2 = Calendar.getInstance();
		
		System.out.println("****** 2-1 ******");
		calendar2.clear();
		System.out.println(calendar2);
		System.out.println(calendar2.getTimeInMillis());
		System.out.println(calendar2.getTime());
		
		System.out.println("****** 2-2 ******");
		Calendar calendar22 = Calendar.getInstance();
		calendar22.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar22.clear();
		System.out.println(calendar22);
		System.out.println(calendar22.getTimeInMillis());
		System.out.println(calendar22.getTime()); //本地时间（北京时间） = 历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00.000，格里高利历）时间 + 8小时。
		
		System.out.println("****** 2-3 ******");
		System.out.println(8 * 60 * 60 * 1000); //28800000 = 8 * 60 * 60 * 1000;
		
		System.out.println("------------------------------ 操作 3：设置 Calendar 字段值 ------------------------------");
		
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2017, 11, 26, 16, 36, 36);
		System.out.println(calendar3.getTime());
		
		calendar3.set(Calendar.DAY_OF_MONTH, 6);
		System.out.println(calendar3.getTime());
		
		
		System.out.println("------------------------------ 操作 4：roll() 方法与 add() 方法的区别 ------------------------------");
		
		/* 
		 * 以下两段代码换位结果不同
		 * roll()与 add()区别
		 */
		System.out.println("****** 4-1 ******");
		Calendar calendar41 = Calendar.getInstance();
		calendar41.set(2017, 11, 11, 16, 36, 36);
		calendar41.roll(Calendar.DAY_OF_MONTH, -12); //不更改更大的字段。
		System.out.println(calendar41.getTime());
		
		System.out.println("****** 4-2 ******");
		Calendar calendar42 = Calendar.getInstance();
		calendar42.set(2017, 11, 11, 16, 36, 36);
		calendar42.add(Calendar.DAY_OF_MONTH, -12); //根据日历的规则，为给定的日历字段添加或减去指定的时间量。
		System.out.println(calendar42.getTime());
		
		
		System.out.println("------------------------------ 操作 5：Date 与 Calendar 获取毫秒数 ------------------------------");
		
		Date date5 = new Date();
		System.out.println(date5.getTime());
		Calendar calendar5 = Calendar.getInstance();
		System.out.println(calendar5.getTimeInMillis());
		
		
		System.out.println("------------------------------ 操作 6：Date 类型转化为 Calendar 类型 ------------------------------");
		
		Date date6 = new Date();
		System.out.println(date6);
		
		Calendar calendar6 = Calendar.getInstance();
		calendar6.setTimeInMillis(date6.getTime()); //Date 类型转化为 Calendar 类型。
		System.out.println(calendar6.getTime());
		
		
		System.out.println("------------------------------ 操作 7：isSet()方法 ------------------------------");
		
		Calendar calendar7 = Calendar.getInstance();
		System.out.println(calendar7);
		System.out.println(calendar7.isSet(Calendar.MONTH));

		calendar7.clear();
		System.out.println(calendar7);
		//calendar7.set(Calendar.MONTH, 1);
		System.out.println(calendar7.isSet(Calendar.MONTH));
		
		
		System.out.println("------------------------------ 操作 8：isLenient()方法 和 setLenient()方法 ------------------------------");
		/*
		 * 宽松性:
		 * Calendar 有两种解释日历字段的模式，即 lenient 和 non-lenient。
		 * 当 Calendar 处于 lenient 模式时，它可接受比它所生成的日历字段范围更大范围内的值。当 Calendar 重新计算日历字段值，以便由 get() 返回这些值时，所有日历字段都被标准化。
		 * 例如，lenient 模式下的 GregorianCalendar 将 MONTH == JANUARY、DAY_OF_MONTH == 32 解释为 February 1。
		 * 当 Calendar 处于 non-lenient 模式时， 如果其日历字段中存在任何不一致性，它都会抛出一个异常。
		 * 例如，GregorianCalendar 总是在 1 与月份的长度之间生成 DAY_OF_MONTH 值。如果已经设置了任何超出范围的字段值，那么在计算时间或日历字段值时，处于 non-lenient 模式下的 GregorianCalendar 会抛出一个异常。
		 */
		
		//lenient 宽松模式
		Calendar calendar8 = Calendar.getInstance();
		System.out.println(calendar8.isLenient());
		calendar8.set(Calendar.MONTH, 32);
		System.out.println(calendar8.getTimeInMillis());
		
		
		//non-lenient 非宽松模式
		calendar8.setLenient(false);
		calendar8.set(Calendar.MONTH, 32);
		try{
			System.out.println(calendar8.getTimeInMillis());
		}catch(IllegalArgumentException e){
			System.out.println("已接收到异常");
		}
		System.out.println(calendar8.isLenient());
		
	}
	
}
