package org.kwok.quartz.exception;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Quartz 执行的任务出现异常时，只会影响本次执行，不会终止该任务。
 * @author Kwok
 */
public class Test_Quartz {

	public static void main(String[] args) throws SchedulerException, InterruptedException {

		// 创建scheduler
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		// 定义一个Trigger
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") // 定义name/group
				.startNow()// 一旦加入scheduler，立即生效
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule() // 使用SimpleTrigger
						.withIntervalInSeconds(1) // 每隔一秒执行一次
						.repeatForever()) // 一直执行
				.build();
		
		Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2") // 定义name/group
				.startNow()// 一旦加入scheduler，立即生效
				.withSchedule(SimpleScheduleBuilder.simpleSchedule() // 使用SimpleTrigger
						.withIntervalInSeconds(1) // 每隔一秒执行一次
						.repeatForever()) // 一直执行
				.build();

		// 定义一个JobDetail
		JobDetail job = JobBuilder.newJob(CustomJob.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
				.withIdentity("job1", "group1") // 定义name/group
				.usingJobData("name", "quartz") // 定义属性
				.build();

		JobDetail job2 = JobBuilder.newJob(CustomJob2.class) // 定义Job类为HelloQuartz类，这是真正的执行逻辑所在
				.withIdentity("job2", "group2") // 定义name/group
				.usingJobData("name", "quartz") // 定义属性
				.build();
		
		// 加入这个调度
		scheduler.scheduleJob(job, trigger);
		scheduler.scheduleJob(job2, trigger2);

		// 启动之
		scheduler.start();

		// 运行一段时间后关闭
		Thread.sleep(10000);
		scheduler.shutdown(true);
	}

}
