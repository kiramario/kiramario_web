package com.kiramario.webInit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;

public class InitServlet extends HttpServlet{
	private static Logger logger = Logger.getLogger(HttpServlet.class);
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		String appid = config.getInitParameter("test_appid");
		String secretKey = config.getInitParameter("test_appsecret");
			/*System.out.println("test_appid s");
		 ServletContext app = getServletContext(); 
		 
		 System.out.println(app.getInitParameter("test_appid"));
		 System.out.println("test_appid");*/
		StandardWxConfig wxconfig = GetBeansFactory.getStandardWxConif();
//		StandardWxConfig wxconfig2 = GetBeansFactory.getStandardWxConif();
		wxconfig.setAppid(appid);
		wxconfig.setSecretKey(secretKey);
//		System.out.println(wxconfig2.getAppid());
		TokenThread token_thread = new TokenThread(wxconfig);
		token_thread.setName("getAccToken_thread");
		token_thread.start();
	}
}
