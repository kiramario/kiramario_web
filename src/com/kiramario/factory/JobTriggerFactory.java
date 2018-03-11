package com.kiramario.factory;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

import com.kiramario.factory.Interf.JobTriggerInterf;
import com.kiramario.factory.Util.jobTrigger.PriceMentionTrigger;

public class JobTriggerFactory {
	private static Logger logger = Logger.getLogger(JobTriggerFactory.class);
	public static PriceMentionTrigger getPriceMentionTrigger(){
		Class clazz = null;
		Constructor c = null;
		PriceMentionTrigger newInstance=null;
		try {
			clazz = Class.forName("com.kiramario.factory.Util.jobTrigger.PriceMentionTrigger");
			c = clazz.getConstructor();
			newInstance=(PriceMentionTrigger)c.newInstance();
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return newInstance;
	}
}
