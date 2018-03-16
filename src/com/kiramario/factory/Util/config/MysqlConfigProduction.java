package com.kiramario.factory.Util.config;

import com.kiramario.factory.Interf.MysqlConfig;

public class MysqlConfigProduction implements MysqlConfig{
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/reptile";
	private String user = "root";
	private String password = "admin@kiramario.com";
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
