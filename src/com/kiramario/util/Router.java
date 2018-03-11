package com.kiramario.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Router {
	private static Logger logger = Logger.getLogger(Router.class);
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private Map<String,Object> requestContent = new HashMap<String, Object>();
	
	public Router(Map<String, Object> requestContent){
		this.requestContent = requestContent;
		this.request = ((HttpServletRequest) requestContent.get("request"));
		this.response = ((HttpServletResponse) requestContent.get("response"));		
	}
	
	public void route(){
		String uri = request.getRequestURI();
		Pattern pat = Pattern.compile(".*\\/s\\/([a-zA-Z\\d]*)(\\/([a-zA-Z\\d]*))?");
		Matcher m = pat.matcher(uri);
		if(m.find()){
			String controllerpat = m.group(1);
			String method = "execute";
			if(m.group(3) != null){
				method = m.group(3);
			}
			
			String className = controllerpat.substring(0, 1).toUpperCase() + controllerpat.substring(1);
			try{
				Class c = Class.forName("com.kiramario.controller."+className);
				Method invokeMethod = c.getMethod(method, Map.class);
				invokeMethod.invoke(c.newInstance(), this.requestContent);
			}catch(Exception e){
				logger.warn("com.kiramario.controller."+className+" exec error");
			}
		}
	}
}
