package com.wipro.bus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDBConnection()
	{
		Connection conn;
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:ORCL";
		String username="B44641345075";
		String pwd="B44641345075";
		conn=DriverManager.getConnection(url,username,pwd);
		return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;	
	}
}
