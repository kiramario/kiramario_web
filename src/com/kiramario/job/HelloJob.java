package com.kiramario.job;

import java.util.ArrayList;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class HelloJob implements Job{
	private String name="kiramario";
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobKey key = context.getJobDetail().getKey();
		JobDataMap dataMap = context.getMergedJobDataMap();
		String jobSay = dataMap.getString("say");
		ArrayList state = (ArrayList) dataMap.get("myStateData");
		System.out.println(key);
	}
}
