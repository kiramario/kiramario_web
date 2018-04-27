package com.kiramario.factory.Util.dao.mapperInter;

import com.kiramario.factory.Util.dto.UserDto;

public interface IUserDto {
	public UserDto selectByOpenId(String openid);
	public int insertUser(UserDto user);
}
