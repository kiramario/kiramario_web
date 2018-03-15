package com.kiramario.factory.Util.config;

import com.kiramario.factory.Interf.MysqlConfig;

public class MysqlConfigLocal implements MysqlConfig{
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test";
	private String user = "root";
	private String password = "root";
	@Override
	public String getDriver() {
		return driver;
	}
	@Override
	public String getUrl() {
		return url;
	}
	@Override
	public String getUser() {
		return user;
	}
	@Override
	public String getPassword() {
		return password;
	}
}
