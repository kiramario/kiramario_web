package com.kiramario.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kiramario.factory.GetConfigFactory;
import com.kiramario.factory.StaticApplications;
import com.kiramario.factory.Util.MysqlConnector;
import com.kiramario.factory.Util.config.MysqlConfigLocal;
public class TestMysql {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MysqlConnector mysqlConnector = StaticApplications.getMysqlConnectorLocal();
		Connection con = mysqlConnector.getConnection();
		Statement statement = (Statement) con.createStatement();
		String sql = "select * from t_jd_price_info where item_id='3541223' order by create_time desc limit 1";
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()){
			System.out.println(rs.getString("price"));
			System.out.println(rs.getString("item_name"));
			System.out.println(rs.getString("create_time").substring(0,19));
		}
		mysqlConnector.closeConnection();
	}

}
