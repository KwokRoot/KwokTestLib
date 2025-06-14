package testlib.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 时间间隔 Duration、日期间隔 Period 的常用方法练习。
 * 2个类 @since 1.8 增加，线程安全。
 * @author Kwok
 * 2025-06-14
 */
public class Test_Time_Duration {

	public static void main(String[] args) {
	
		System.out.println("--------- 时间间隔 Duration ---------");
		// Duration 基于时间（Time-based）的间隔​​（小时、分钟、秒、纳秒），格式：PnDTnHnMn.nS
		System.out.println(Duration.parse("PT1H30m30.00S").plusHours(-2).toMinutes());

		// 2个 LocalDateTime 之间的时间间隔
		System.out.println(Duration.between(LocalDateTime.of(2008, Month.AUGUST, 8, 20, 0, 0), LocalDateTime.now()).toDays());
	
		System.out.println(Duration.of(72, ChronoUnit.HOURS).toMillis());
		
		System.out.println(Duration.ofDays(1).plusHours(-2).minusHours(2).toHours());
		
		
		System.out.println("--------- 日期间隔 Period ---------");
		// Period 基于日期（Date-based）的间隔​​（年、月、日），格式：PnYnMnD
		System.out.println(Period.parse("P1Y2M3W4D"));
		
		// 2个 LocalDate 之间的日期间隔
		System.out.println(Period.between(LocalDate.of(2008, 8, 8), LocalDate.now()));
		
		System.out.println(Period.of(34, 2, 0).toTotalMonths());
		
	}

}
