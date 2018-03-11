package com.kiramario.webInit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
//		System.out.println("ContextListener destory");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	/*	TokenThread tokenthread = TokenThread.getInstance();
		tokenthread.start();*/
//		System.out.println("ContextListener int");
	}

}
