package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;

public class LeaveUpdate implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		Map<String, Object> map2 = new HashMap<>();
		PreparedStatement preparedStatement = null;
		try {
			
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		int serialNum = Integer.parseInt(map.get("serialNo"));
		System.out.println("serial%%%%%%%%%%%"+serialNum);
		String status=map.get("status");
		
		try {
			preparedStatement = con.prepareStatement(Constant.updateleaveStatus);
			int update=0;
			
				preparedStatement.setString(1, status);
				preparedStatement.setInt(2, serialNum);
				update=preparedStatement.executeUpdate();
			System.out.println("update@@@@@@@@@@@@"+update);
			if(update > 0) {
				String uri = "success";
				map2.put(Constant.uriPath, uri);
			}
			else {
				 String uri = "error"; 
				 map2.put(Constant.uriPath, uri);
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(con!=null) {
					Constant.db.releaseDbConnection(con);
					con.close();
				}if(preparedStatement!=null) {
					preparedStatement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map2;
	}
}
