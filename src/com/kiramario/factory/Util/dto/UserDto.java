package com.kiramario.factory.Util.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kiramario.factory.Interf.DtoInterf;

@Scope("prototype")
@Repository
public class UserDto implements DtoInterf{
	private int id;
	private String nickname;
	private String name;
	private String phone;
	private String openid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Override
	public String toString(){
		return "id: " + id + "; nickname: " + nickname + "; name: " + name + "; phone:" + phone + 
				"; openid: "+ openid;
	}
	
}
