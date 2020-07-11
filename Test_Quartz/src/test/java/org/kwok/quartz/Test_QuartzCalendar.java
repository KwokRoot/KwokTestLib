package org.kwok.quartz;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

public class Test_QuartzCalendar {

	public static void main(String[] args) throws SchedulerException, ParseException {

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.clear();
		
		HolidayCalendar cal = new HolidayCalendar();
		//Add the given Date to the list of excluded days. Only the month, day andyear of the returned dates are significant.
		cal.addExcludedDate(DateBuilder.dateOf(23, 0, 0, 12, 7));
		scheduler.addCalendar("myHolidays", cal, false, false);
		
		System.out.println(new Date(cal.getNextIncludedTime(DateUtils.parseDate("2020-07-12", "yyyy-MM-dd").getTime())));
		
		System.out.println(cal.isTimeIncluded(DateUtils.parseDate("2020-07-12", "yyyy-MM-dd").getTime()));
		
		
		scheduler.shutdown(true);
		
	}

}
