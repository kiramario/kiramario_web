package com.kiramario.test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;

import static org.quartz.SimpleScheduleBuilder.*;
public class Qutarzdemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler sched = sf.getScheduler();
			sched.start();
			
			JobDetail job = newJob(com.kiramario.job.HelloJob.class)
								.withIdentity("myJob","group1")
								.usingJobData("say","hello world")
								.usingJobData("myFloatValue", 3.141f)
								.build();
			Trigger trigger = newTrigger()
								.withIdentity("myTrigger","group1")
								.startNow()
								.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
								.forJob("myJob", "group1")
								.build();
			sched.scheduleJob(job,trigger);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
