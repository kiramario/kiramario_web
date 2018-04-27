package com.kiramario.webInit;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kiramario.factory.JobTriggerFactory;
import com.kiramario.factory.Util.dto.YsStatistic;
import com.kiramario.factory.Util.jobTrigger.PriceMentionNeicunTrigger;
import com.kiramario.factory.Util.jobTrigger.PriceMentionTrigger;

public class JobExecute {
	private static Logger logger = Logger.getLogger(JobExecute.class);
	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		PriceMentionTrigger jobTrig = JobTriggerFactory.getPriceMentionTrigger();
		jobTrig.startJob();
		PriceMentionNeicunTrigger jobTrigNeicun = JobTriggerFactory.getPriceMentionNeicunTrigger();
		jobTrigNeicun.startJob();
	
	}
}
