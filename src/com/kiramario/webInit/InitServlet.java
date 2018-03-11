package com.kiramario.webInit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.StandardWxConfig;
import com.kiramario.factory.Util.jobTrigger.PriceMentionTrigger;
import com.kiramario.factory.JobTriggerFactory;
public class InitServlet extends HttpServlet{
	private static Logger logger = Logger.getLogger(HttpServlet.class);
	@Override
	public void init(ServletConfig config) throws ServletException{
		String appid = config.getInitParameter("test_appid");
		String secretKey = config.getInitParameter("test_appsecret");
		StandardWxConfig wxconfig = StaticApplications.getStandardWxConif();
		wxconfig.setAppid(appid);
		wxconfig.setSecretKey(secretKey);
		TokenThread token_thread = new TokenThread(wxconfig);
		token_thread.setName("getAccToken_thread");
		token_thread.start();
		
		PriceMentionTrigger jobTrig = JobTriggerFactory.getPriceMentionTrigger();
		jobTrig.startJob();
	}
}
