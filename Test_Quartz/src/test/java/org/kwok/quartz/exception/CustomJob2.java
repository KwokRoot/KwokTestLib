package org.kwok.quartz.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class CustomJob2 implements Job {

	public void execute(JobExecutionContext arg0) {
		
		System.out.println(arg0.getJobDetail().getKey() + ":" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		int i = 1/0;
		System.out.println(i);
	}

}
