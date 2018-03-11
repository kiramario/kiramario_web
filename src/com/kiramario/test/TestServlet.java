package com.kiramario.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	 @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 response.setHeader("content_type", "text/html;charset=UTF-8");
		 test1(response);
	 }
	 
	 private void test1(HttpServletResponse response) throws IOException{
		 ClassLoader loader = TestServlet.class.getClassLoader();
		/* InputStream in = loader.getResourceAsStream("com/resources/test.properties");
		 
		 Properties prop = new Properties();
		 prop.load(in);
		 String name = prop.getProperty("name");
		 response.getWriter().println(MessageFormat.format("name={0}", name));*/
		 
	/*	 InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/resources/java_video.wmv");
		 String path = this.getServletContext().getRealPath("/WEB-INF/classes/com/resources/java_video.wmv");
		 System.out.println(path);
		 System.out.println(path.substring(path.lastIndexOf("\\") + 1));
		 System.out.println(in);
		 
		 byte[] buffer = new byte[1024];
		 int len = 0;
		 
		 OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\s.wmv");
		 while((len=in.read(buffer))>0){
			 out.write(buffer, 0, len);
		 }
		 out.close();
		 in.close();*/
		 
		/* String data = "good day ";
		 response.setDateHeader("expires", System.currentTimeMillis() + 60 * 1000);
		 response.getOutputStream().write(data.getBytes());*/
	 }
}
