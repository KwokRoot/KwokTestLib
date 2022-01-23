package testlib.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/**
 * 了解 java.util.Calendar.setFirstDayOfWeek() 与 java.util.Calendar.setMinimalDaysInFirstWeek() 方法的作用。
 * @date: 2020年1月16日
 * @author Kwok
 */
public class Test_CalendarWeekYear {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		 
		Calendar calendar = Calendar.getInstance(Locale.CHINESE);
		calendar.set(2019, 11, 29);
		System.out.println(calendar.getTime());
		//输出：Sun Dec 29 14:40:10 CST 2019
		System.out.println(sdf.format(calendar.getTime())); 
		//输出：2019-12-29
		
		System.out.println("一周的第一天：" + (calendar.getFirstDayOfWeek() == Calendar.SUNDAY? "周日" : "周一")); 
		//输出：一周的第一天：周日
		System.out.println(calendar.getWeekYear()); 
		//输出：2020
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR)); 
		//输出：1
		
		
		
		System.out.println("------------------");
		
		/*设置在一年中第一个星期所需最少天数，默认1*/
		calendar.setMinimalDaysInFirstWeek(7);
		System.out.println("一周的第一天：" + (calendar.getFirstDayOfWeek() == Calendar.SUNDAY? "周日" : "周一")); 
		//输出：一周的第一天：周日
		System.out.println(calendar.getWeekYear()); 
		//输出：2019
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR)); 
		//输出：52
		
		
		
		System.out.println("------------------");
		
		/*设置一周的第一天为周一*/
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		
		System.out.println("一周的第一天：" + (calendar.getFirstDayOfWeek() == Calendar.SUNDAY? "周日" : "周一")); 
		//输出：一周的第一天：周一
		System.out.println(calendar.getWeekYear()); 
		//输出：2019
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR)); 
		//输出：51
		
		
		
		System.out.println("------------------");
		
		Calendar calendar2 = Calendar.getInstance(Locale.CHINESE);
		calendar2.set(Calendar.YEAR, 2022);
		calendar2.set(Calendar.MONTH, 0);
		calendar2.set(Calendar.DAY_OF_MONTH, 23);
		System.out.println(calendar2.getTime());
		
		//一年中的第几周
		System.out.println(calendar2.get(Calendar.WEEK_OF_YEAR));
		//一月中的第几周
		System.out.println(calendar2.get(Calendar.WEEK_OF_MONTH));
		//一周中的第几天
		System.out.println(calendar2.get(Calendar.DAY_OF_WEEK));
		
		//设置一周的第一天为周一
		calendar2.setFirstDayOfWeek(Calendar.MONDAY);
		//设置本年第一周最少包含3天
		calendar2.setMinimalDaysInFirstWeek(3);
		
		
		/*
		 * 结论：
		 * setFirstDayOfWeek()、setMinimalDaysInFirstWeek() 方法
		 * 会影响到 WEEK_OF_YEAR、WEEK_OF_MONTH 取值
		 * 不会影响 DAY_OF_WEEK 取值
		 * DAY_OF_WEEK 取值，DAY_OF_WEEK 返回的 Calendar.SUNDAY = 1..，Calendar.SATURDAY = 7 则不会变。
		 */
		System.out.println(calendar2.get(Calendar.WEEK_OF_YEAR));
		System.out.println(calendar2.get(Calendar.WEEK_OF_MONTH));
		System.out.println(calendar2.get(Calendar.DAY_OF_WEEK));
		
		
		System.out.println("------------------ 2022年1月份日历 ------------------");
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2022, 0, 1);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日\n").format(calendar3.getTime()));
		int curMonthDayCount = calendar3.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weekDay = calendar3.get(Calendar.DAY_OF_WEEK) - 2;
		System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t", "周一", "周二", "周三", "周四", "周五", "周六", "周日"));
		ArrayList<String> dayList = new ArrayList<String>();
		if(weekDay < 0) {
			//周日
			weekDay = weekDay + 7;
		}
		for (int i = 0; i < weekDay; i++) {
			dayList.add("");
		}
		for (int i = 1; i <= curMonthDayCount; i++) {
			dayList.add(String.valueOf(i));
		}
		for (int i = 0; i < dayList.size(); i++) {
			System.out.print(dayList.get(i) + "\t");
			if ((i + 1) % 7 == 0) {
				System.out.println();
			}
		}
		
	}
	
}
