package com.kiramario.factory.Util.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kiramario.factory.GetBeansFactory;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Interf.ServiceInterf;
import com.kiramario.factory.Util.dao.mapperInter.IUserDto;
import com.kiramario.factory.Util.dto.UserDto;
import com.kiramario.factory.Util.staticItems.StandardWxConfig;
import com.kiramario.util.HttpsConnect;

@Scope("prototype")
@Service
public class UserService implements ServiceInterf{
	private static Logger logger = Logger.getLogger(UserService.class);
	
	public int initUser(String openid) {
		int error_id = 0;
		UserDto dto = GetBeansFactory.getUserDto();
		SqlSession session = StaticApplications.getMybatisSession();
		IUserDto us = session.getMapper(IUserDto.class);
		dto = us.selectByOpenId(openid);
		session.commit();
		try{
			if(dto == null){
				UserDto dto_new = GetBeansFactory.getUserDto();
				dto_new.setOpenid(openid);
				int rows = us.insertUser(dto_new);
				error_id = dto_new.getId();
				session.commit();
			}else{
				error_id = dto.getId();
			}
		}catch(Exception e){
			logger.error(e.toString());
		}finally{
			session.close();
		}
		return error_id;
	}
	
	public static void main(String[] args){
		/*UserService u = new UserService();
		System.out.println(u.initUser("feef"));*/
	}
}
