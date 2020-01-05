package org.kwok.quartz;

import org.quartz.DateBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

public class Test_QuartzCalendar {

	public static void main(String[] args) throws SchedulerException {

		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		
		HolidayCalendar cal = new HolidayCalendar();
		//Add the given Date to the list of excluded days. Only the month, day andyear of the returned dates are significant.
		cal.addExcludedDate(DateBuilder.dateOf(23, 0, 0));
		
		scheduler.addCalendar("myHolidays", cal, false, false);
	}

}
