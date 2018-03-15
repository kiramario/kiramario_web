package com.kiramario.factory.Util.jobTrigger;


import static org.quartz.TriggerBuilder.newTrigger;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.kiramario.factory.JobUtilFactory;
import com.kiramario.factory.Interf.JobTriggerInterf;
public class PriceMentionTrigger implements JobTriggerInterf{
	private static Logger log = Logger.getLogger(PriceMentionTrigger.class);
	private Scheduler sched = null;

	@Override
	public void startJob(){
		SchedulerFactory sf = new StdSchedulerFactory();
		
		try {
			this.sched = sf.getScheduler();
			this.sched.start();

			JobDetail job = JobUtilFactory.getPriceMentionJob();
			Trigger trigger = newTrigger()
								.withIdentity("PriceMentionTrigger","group_sendTemplate_trigger")
								.startNow()
								.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
								.forJob("PriceMentionJob", "group_sendTemplate")
								.build(); 
			this.sched.scheduleJob(job,trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			log.error("[PriceMentionTrigger]:" + e.toString());
		}
		
/*		try{
			Thread.sleep(30000);
		}catch(Exception e){
			e.printStackTrace();
		}
		this.stopJob();*/
		
	}

	@Override
	public void stopJob() {
		try {
			this.sched.shutdown(true);
		} catch (SchedulerException e) {
			log.error("[PriceMentionTrigger]:" + e.toString());
		}
	}
	
/*	public static void main(String[] args){
		PriceMentionTrigger t = new PriceMentionTrigger();
		t.startJob();
	}*/
}
