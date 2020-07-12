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
 * 测试正在执行的任务，重启程序会不会恢复。
 * 测试结果：
 * ①正在执行的任务中止后，默认不会恢复执行！
 * ②单单修改系统时间也无法恢复执行！需要移除之前的任务，重新添加该任务。
 * @author Kwok
 */
public class Test_QuartzRestart {

	public static void main(String[] args) throws Exception {

		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		// scheduler.clear();

		JobDetail job = JobBuilder.newJob(costTimeJob.class)
				.withIdentity("job1", "group1")
				.usingJobData("jobParam", "hello").build();

		CronTrigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder
						.cronSchedule("0 28 20 * * ?")
						.withMisfireHandlingInstructionIgnoreMisfires())
				.build();
		/*
		 * scheduler.deleteJob(JobKey.jobKey("job1", "group1"));
		 * 
		 * Date fireDate = scheduler.scheduleJob(job, trigger);
		 * System.err.println("下一次执行时间：" + fireDate);
		 */
		
	}

	public static class costTimeJob implements Job {

		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			System.out.println("开始执行...");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("time:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
		}

	}
}
