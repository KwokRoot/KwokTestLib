package org.kwok.quartz.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CustomJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		System.out.println(arg0.getJobDetail().getKey() + ":" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		

	}

}
