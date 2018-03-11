package com.kiramario.factory.Interf;

public interface MysqlConfig extends Config{
	public String getDriver();
	public String getUrl();
	public String getUser();
	public String getPassword();
}
