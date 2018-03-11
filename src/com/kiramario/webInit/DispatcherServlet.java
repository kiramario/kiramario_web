package com.kiramario.webInit;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kiramario.util.Router;


public class DispatcherServlet extends HttpServlet{
	private String encoding = null;
	private String DEFAULT_ENCODING = "UTF-8";
	private ServletConfig config = null;
	private Map<String, Object> requestContent = new HashMap<String,Object>();
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/plain;charset="+encoding);
		response.setCharacterEncoding(encoding);
		response.setHeader("Access-Control-Allow-Origin", "*");
		getRequestContent(request, response);
		
		Router route = new Router(requestContent);
		route.route();
	}
	
	
	public void getRequestContent(HttpServletRequest request,HttpServletResponse response){
		this.requestContent.put("request", request);
		this.requestContent.put("response", response);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	
		this.encoding = this.config.getInitParameter("encoding");

		if (this.encoding == null) {
			this.encoding = DEFAULT_ENCODING;
		}
	}
	
	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		System.out.println(System.getProperty("file.encoding"));
	}
}
