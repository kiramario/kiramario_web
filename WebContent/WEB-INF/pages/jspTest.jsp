<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		private int initVar = 0;
		private int serviceVar = 0;
		private int destoryVar = 0;
	%>
	
	<%!
		
	
		public void jspInit()
		{
			initVar++;
			System.out.println("jspInit(): JSP被初始化了"+initVar+"次");
		}
		
		public void jspDestroy()
		{
			destoryVar++;
			System.out.println("jspDestroy(): JSP被销毁了"+destoryVar+"次");
		}
		
		public String test(){
			return "hello test";
		}

	%>
	
	<%@ 
		page import="java.text.SimpleDateFormat,java.util.Date"
	%>
	<%
		serviceVar++;
		System.out.println("_jspService(): JSP共响应了"+serviceVar+"次请求");

		  String content1="初始化次数 : "+initVar;
		  String content2="响应客户请求次数 : "+serviceVar;
		  String content3="销毁次数 : "+destoryVar;
		  String content_test = test();
		  out.println("Your IP address is " + request.getRemoteAddr());
	%>
	<h1>${message}</h1>
	<div><%=content1 %></div>
	<div><%=content2 %></div>
	<div><%=content3 %></div>
	<div><%=content_test %></div>
	<%-- 该部分注释在网页中不会被显示--%> 
	<p>
		今天的日期是 <\% <%= (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format((new Date())) %>
	</p>
	
	<jsp:include page="hello.jsp" flush="true" />
	<%-- <jsp:forward page="hello.jsp" /> --%> 
	
	<jsp:useBean id="ys" class="com.kiramario.factory.Util.dto.YsStatistic" />
	<jsp:setProperty name="ys" property="item_detail" value="authen_test"/>
	<jsp:getProperty name="ys" property="item_detail" />
	
	<%--
	<jsp:plugin type="applet" codebase="dirname" code="MyApplet.class"
				with="60" height="80">
		<jsp:param name="fontcolor" value="red" />
		<jsp:param name="background" value="black" />
		
		 <jsp:fallback>
      		Unable to initialize Java Plugin
   		</jsp:fallback>
	</jsp:plugin>
	 --%>
	 
	 <jsp:element name="xmlElement">
	 	<jsp:attribute name="xmlElementAttr" >
	 		属性值
	 	</jsp:attribute>
	 	<jsp:body>
	 		 XML 元素的主体
	 	</jsp:body>
	 </jsp:element>
	 
	 <table width="50%" border="1" align="center">
	 	<thead>
	 		<tr bgcolor="#949494">
				<th>Header Name</th><th>Header Value(s)</th>
			</tr>
	 	</thead>
	 	<tbody>
	 	<%@ page import="java.io.*,java.util.*" %>
 		<%
 			Enumeration headerNames = request.getHeaderNames();
 			while(headerNames.hasMoreElements()){
 				String paramName = (String)headerNames.nextElement();
 				out.print("<tr><td>"+paramName+"</td>");
 				String paramValue = request.getHeader(paramName);
 				out.print("<td>" + paramValue + "</td></tr>");
 			}
 		%>
	 	</tbody>
	 </table>
	 
	 <%
	 response.setHeader("refresh", "3");
	 	Calendar calendar = new GregorianCalendar();
	 	String am_pm;
	 	int hour = calendar.get(Calendar.HOUR);
	 	int minute = calendar.get(Calendar.MINUTE);
	 	int second = calendar.get(Calendar.SECOND);
	 	
	 	if(calendar.get(Calendar.AM_PM)==0){
	 		am_pm="am";
	 	}else{
	 		am_pm="pm";
	 	}
	 	String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	 	out.println("当前时间: " + CT + "\n");
	 %>
	 
	 <%
	 	Date createTime = new Date(session.getCreationTime());
	 	Date lastAccessTime = new Date(session.getLastAccessedTime());
	 	String title = "再次访问菜鸟教程实例";
	    Integer visitCount = new Integer(0);
	    String visitCountKey = new String("visitCount");
	    String userIDKey = new String("userID");
	    String userID = new String("ABCD");
	    
	    if(session.isNew()){
	    	title = "访问菜鸟教程实例";
	    	session.setAttribute(userIDKey,userID);
	    	session.setAttribute(visitCountKey,visitCount);	
	    }else{
	    	visitCount = (Integer)session.getAttribute(visitCountKey);
	    	visitCount += 1;
	    	userID = (String)session.getAttribute(userIDKey);
	    	session.setAttribute(visitCountKey,visitCount);
	    }
	 %>
	 
	 <hr/>
	 
	 <table border="1" align="center"> 
	 	<thead>
	 		<tr bgcolor="#949494">
			   <th>Session 信息</th>
			   <th>值</th>
			</tr>
	 	</thead>
	 	
		<tbody>
			<tr>
				<td>id</td>
				<td><% out.print(session.getId()); %></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><% out.print(createTime); %></td>
			</tr>
			<tr>
				<td>最后访问时间</td>
				<td><% out.print(lastAccessTime); %></td>
			</tr> 
			<tr>
				<td>用户 ID</td>
				<td><% out.print(userID); %></td>
			</tr> 
			<tr>
				<td>访问次数</td>
				<td><% out.print(visitCount); %></td>
			</tr> 
		</tbody>
	 </table>
	 
	 <%
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		out.print( "<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
		out.print( "<h2 align=\"center\">" + dNow.toString() + "</h2>");
	%>
	 
</body>
</html>