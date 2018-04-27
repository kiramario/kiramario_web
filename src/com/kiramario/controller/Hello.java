package com.kiramario.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.kiramario.factory.Util.dto.JdPriceInfoDto;
import com.kiramario.factory.Util.dto.YsStatistic;

import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class Hello {

	@RequestMapping("/web/en/{pagename}")
//	@ResponseBody
	public String helloworld(
				HttpServletRequest request, HttpServletResponse response,Model model,
				@PathVariable(value = "pagename") String pagename){
		String name_1 = request.getParameter("name");
/*		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();*/
		ApplicationContext wac = new ClassPathXmlApplicationContext("applicationContext.xml");
		YsStatistic ys = (YsStatistic)wac.getBean("ysStatistic");
		System.out.println(ys);
		YsStatistic ys2 = (YsStatistic)wac.getBean("ysStatistic");
//		ys2.setId(2);
//		ys2.setItem_belong("fefefef");
		System.out.println(ys2);
		
		System.out.println(ys==ys2);
		model.addAttribute("greeting", "Hello Spring MVC "  + ": " + name_1);
		return pagename;
	
	}
	
	@RequestMapping("/authen")
	public ModelAndView authenPage(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		ModelAndView modelAndView = new ModelAndView();
		if ("hello".equals(name)) {
            return new ModelAndView("redirect:/web/en/hello");
        }
        modelAndView.setViewName("wxAuthen");
        modelAndView.addObject("message", "Hello World, Hello Kitty");
        return modelAndView;
	}
	
	public static void main(String[] arg){
		/*ApplicationContext applicationContext;
		applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		YsStatistic instance = (YsStatistic)applicationContext.getBean("ysStatistic");
		System.out.println(instance);*/
	}
}