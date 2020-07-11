package org.kwok.quartz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Quartz 触发超时设置：`quartz.properties` 配置文件中 org.quartz.jobStore.misfireThreshold=60000 为 超时阀值(ms)设置。
 * Quartz 触发超时定义：当`延时 > misfireThreshold值` 为触发超时，即：misfire。
 * @author Kwok
 */
public class Test_QuartzMisfire {

	public static void main(String[] args) throws Exception {
		
		SchedulerFactory sf = new StdSchedulerFactory();
	    Scheduler scheduler = sf.getScheduler();
	    scheduler.start();
	    //scheduler.clear();
	    
	    JobDetail job = JobBuilder
	    		.newJob(costTimeJob.class)
	    		.withIdentity("job1", "group1")
	    		.usingJobData("jobParam", "hello")
	    		.build();

	    CronTrigger trigger = TriggerBuilder
	    		.newTrigger()
	    		.withIdentity("trigger1", "group1")
	    		.withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")
	    				.withMisfireHandlingInstructionFireAndProceed())
	        .build();
		/*
		 * scheduler.deleteJob(JobKey.jobKey("job1", "group1"));
		 * 
		 * Date fireDate = scheduler.scheduleJob(job, trigger);
		 * System.err.println("下一次执行时间：" + fireDate);
		 */
	}
	
	public static class costTimeJob implements Job{

		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			
			System.out.println("time:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
			
		}
		
	}
}
