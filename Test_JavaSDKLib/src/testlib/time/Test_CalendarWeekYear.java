package testlib.time;

import java.text.SimpleDateFormat;
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
		
	}
	
}
