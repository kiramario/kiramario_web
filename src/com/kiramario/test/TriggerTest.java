package com.kiramario.test;

import org.junit.Test;

import com.kiramario.factory.JobTriggerFactory;

public class TriggerTest {

	@Test
	public void test() {
		(JobTriggerFactory.getPriceMentionTrigger()).startJob();
	}

}
