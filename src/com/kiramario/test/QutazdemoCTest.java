package com.kiramario.test;

import java.util.Date;
import static org.quartz.DateBuilder.evenMinuteDate;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class QutazdemoCTest {
	private static Logger _log = LoggerFactory.getLogger(QutazdemoCTest.class);
	public static void main(String[] args) throws SchedulerException{
		// TODO Auto-generated method stub
		test1();
	}
	public static  void test1() throws SchedulerException{
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try{
			scheduler = schedulerFactory.getScheduler();
			_log.info("------- Scheduling Job  -------------------");
			JobDetail jobDetail = JobBuilder.newJob(com.kiramario.job.QutazdemoC.class).withIdentity("qutazdemoCjob", "job-group1")
					.usingJobData("say","hello world")
					.build();
			
			Date runTime = evenMinuteDate(new Date());
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("qutazdemoCtrigger","job-group1").startAt(runTime)
					.build();
			scheduler.scheduleJob(jobDetail,trigger);
			_log.info(jobDetail.getKey() + " will run at: " + runTime);
			scheduler.start();

		    _log.info("------- Started Scheduler -----------------");
		    
		    _log.info("------- Waiting 65 seconds... -------------");
		    try {
		      // wait 65 seconds to show job
		      Thread.sleep(65L * 1000L);
		      // executing...
		    } catch (Exception e) {
		      //
		    }
		    
		    _log.info("------- Shutting Down ---------------------");
			scheduler.shutdown(true);
		}catch(SchedulerException | ParseException e){
			e.printStackTrace();
		}
	}
}
