package com.training.connection;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectionClass 
{
	public static Connection getPostgresConnection()
	{
		Connection con=null;
		ResourceBundle labels = ResourceBundle.getBundle("Db");
		try 
		{
			
			String url = labels.getString("datasource.postgres.url");
			String username = labels.getString("datasource.postgres.username");
			String password = labels.getString("datasource.postgres.password");
			
			String driverClass = labels.getString("datasource.postgres.driverclass");
			Class.forName(driverClass);
			
			con=DriverManager.getConnection(url,username,password);
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
