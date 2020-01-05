package org.kwok.quartz;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;

/**
 * Quartz org.quartz.DateBuilder 类
 * @author Kwok
 */
public class Test_QuartzDate {

	public static void main(String[] args) {

		System.out.println(new Date());
		//5分钟之后
		System.out.println(DateBuilder.futureDate(5, IntervalUnit.MINUTE));
		
		System.out.println(DateBuilder.evenHourDate(new Date()));
		
		System.out.println(DateBuilder.nextGivenSecondDate(null, 15));
		
		System.out.println(DateBuilder.dateOf(16, 0, 0, 19, 10, 2019));

	}

}
