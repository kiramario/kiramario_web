<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>authen</title>
</head>
<body>
	<%@ page import="javax.servlet.http.HttpServletRequest,
					com.kiramario.factory.Util.service.WxApiService,
					com.kiramario.factory.Util.service.UserService,
					com.kiramario.factory.GetServicesFactory,
					com.alibaba.fastjson.JSON,
					com.alibaba.fastjson.JSONObject,
					org.apache.log4j.Logger" 
	%>
	
	<%!
		public boolean jumpAuthen(HttpServletRequest request){
			boolean flag = true;
			if(request.getParameter("code") != null){
				flag = false;
			}
			return flag;
			/* return false; */
		}
	
		public boolean sessionHasOpenid(HttpSession session){
			if("".equals((String)session.getAttribute("openid")) 
				|| null==session.getAttribute("openid")){
				return false;
			}else{
				return true;
			}
		}
		

	%>

	<%
		Logger logger = Logger.getLogger(this.getClass());
		if(session.isNew() || !sessionHasOpenid(session)){
			if(jumpAuthen(request)){
				String appid = config.getServletContext().getInitParameter("test_appid");
				//String basePath = request.getScheme()+"://"+request.getServerName()+request.getContextPath()+"/";
				String redictUrl = "http://www.kiramario.com/kw/s/wb/authen";
				
				String wxAuthenUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+redictUrl+"&response_type=code&scope=snsapi_userinfo&state=userinfo#wechat_redirect";
				
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				response.setHeader("Location", wxAuthenUrl);
			}else{
 				String code = request.getParameter("code");
				WxApiService ws = GetServicesFactory.getWxApiService();
				JSONObject res = ws.authenByUser(code);
				ws=null; 

				
				/* String test_string = "{\"access_token\":\"9_2TAhZYbPg65QyR9QpPa-1i2wE2ex8jlIk59VckhG3Z4TroFAjN0aZmRY-gc9bCvXi4IyUo32HskdMrFlFwWq0g\",\r\n"
						+ " \"expires_in\":7200,\r\n"
						+ " \"openid\":\"oBKfS0Tk8toPtoMY_C_2QQ_d7SmI\", \r\n"
						+ " \"refresh_token\":\"9_O2XDHub7pVeGvaDPLos-IyvIhk58FHiBU2QZ707zMOOnSuyuSyXt40YQtKu0aYekpQpLFFY7Pu-JkSPE6nqPoQ\", \r\n"
						+ " \"scope\":\"snsapi_userinfo\"}";
						
				JSONObject res = JSON.parseObject(test_string); */
				
				UserService us = GetServicesFactory.getUserService();
				int error_id = us.initUser((String)res.get("openid"));
				if(error_id==0){
					logger.error("init user failed: " + res.get("openid"));
				}
				session.setAttribute("openid",res.get("openid"));
				logger.info("openid: " + res.get("openid") + "; user_id: " + error_id + " has been inited");
 				response.setStatus(response.SC_MOVED_TEMPORARILY);
 				response.setHeader("Location", "http://www.kiramario.com/kw/dist/index.html?openid="+res.get("openid"));
			}
		}else{
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "http://www.kiramario.com/kw/dist/index.html?openid="+session.getAttribute("openid"));
		}
	%>
</body>
</html>