package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;

public class LeaveUpdate implements Command
{
	
	Connection con = null;
	BasicConnectionPool bc = null;
	Map<String, Object> map2 = new HashMap<>();
	PreparedStatement preparedStatement = null;
	
	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int serialNum = Integer.parseInt(map.get("serialNo"));
		String status=map.get("status");
		String sql="update leave_entity set status =? where serial_no=?";
	
		try {
			preparedStatement = con.prepareStatement(sql);
			int update=0;
			
				preparedStatement.setString(1, status);
				preparedStatement.setInt(2, serialNum);
				update=preparedStatement.executeUpdate();
			
			if(update > 0) {
				String uri = "SupervisorDashboard.jsp";
				map2.put(Constant.uriPath, uri);
			}
			else {
				 String uri = "alreadyexiterror.jsp"; map2.put(Constant.uriPath, uri);
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				preparedStatement.close();
				con.close();
				bc.releaseConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map2;
	}
}
