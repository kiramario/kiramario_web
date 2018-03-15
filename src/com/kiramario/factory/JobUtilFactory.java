package com.kiramario.factory;

import static org.quartz.JobBuilder.newJob;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;

public class JobUtilFactory {
	private static Logger logger = Logger.getLogger(JobUtilFactory.class);
	
	public static JobDetail getPriceMentionJob(){
		JobDetail job = newJob(com.kiramario.factory.Util.job.PriceMentionJob.class)
				.withIdentity("PriceMentionJob","group_sendTemplate")
				.build();
		return job; 
	}
	
	public static JobDetail getPriceMentionJobNeicun(){
		JobDetail job = newJob(com.kiramario.factory.Util.job.PriceMentionJobNeicun.class)
				.withIdentity("PriceMentionJobNeicun","group_sendTemplate")
				.build();
		return job; 
	}
}
