package com.kiramario.webInit;

import org.apache.log4j.Logger;

/*import com.kiramario.factory.JobTriggerFactory;
import com.kiramario.factory.Util.jobTrigger.PriceMentionNeicunTrigger;
import com.kiramario.factory.Util.jobTrigger.PriceMentionTrigger;*/

public class JobExecute {
	static{
		try{
			Logger logger = Logger.getLogger(JobExecute.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("good");
		/*PriceMentionTrigger jobTrig = JobTriggerFactory.getPriceMentionTrigger();
		jobTrig.startJob();
		PriceMentionNeicunTrigger jobTrigNeicun = JobTriggerFactory.getPriceMentionNeicunTrigger();
		jobTrigNeicun.startJob();*/
	}

}
