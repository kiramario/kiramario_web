package com.kiramario.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class QutazdemoC implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 JobKey key = context.getJobDetail().getKey();
		 JobDataMap dataMap = context.getMergedJobDataMap();
		 String jobSay = dataMap.getString("say");
		 System.out.println("instance: " + key + "; say: " + jobSay);
	}

}
