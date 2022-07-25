package com.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {
	public BasicConnectionPool bc=null;
	Connection con=null;
	private static String url="jdbc:postgresql://localhost:5432/vastpro";
	private static String user="postgres";
	private static String password="postgres";
	
	 public DbConnection() {
		 
	 }
	public static BasicConnectionPool createDbConnection=null;
		static {	
		try {
			createDbConnection=BasicConnectionPool.create(url,user,password);
			System.out.println("createCon%%%%%5"+createDbConnection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getDbConnection() throws SQLException {
		 con=createDbConnection.getConnection();
		 System.out.println("$$$%^&*(#%^"+con);
		return con;
	}
	public Boolean releaseDbConnection(Connection con) {
		Boolean value=createDbConnection.releaseConnection(con);
		return value;	
	}
}
