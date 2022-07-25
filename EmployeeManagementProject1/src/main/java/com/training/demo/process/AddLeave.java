package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.training.iface.Command;
import com.training.iface.Constant;
public class AddLeave implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		HttpSession httpSession = request.getSession(); 
		Map<String, Object> resultMap = new HashMap<>();
		  try { 
			  System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
		  System.out.println("add====" + con); 
		  } catch (SQLException e1) {
		  e1.printStackTrace(); }
		  
		String employeeId = map.get(Constant.employeeId);
		String employeeName = map.get("employeeName");
		String fromDate =map.get("fromDate");
		String toDate = map.get("toDate");
		String reason = map.get("reason");
		String managerId = map.get("managerId");
		String status = map.get("status");

		PreparedStatement custpreparedStatement = null;
			
		try {
			custpreparedStatement = con.prepareStatement(Constant.insertLeaveEntity);
			custpreparedStatement.setString(1, employeeId);
			custpreparedStatement.setString(2, employeeName);
			custpreparedStatement.setString(3, fromDate);
			custpreparedStatement.setString(4, toDate);
			custpreparedStatement.setString(5, reason);
			custpreparedStatement.setString(6, managerId);
			custpreparedStatement.setString(7, status);
			custpreparedStatement.executeUpdate();
			
			String message="Submited Successfully";
			String uri = "success";
			resultMap.put(Constant.message, message);
			resultMap.put(Constant.uriPath, uri);
			resultMap.put(Constant.employeeId, employeeId);
			resultMap.put(Constant.employeeName, employeeName);
			httpSession.setAttribute(Constant.message, resultMap.get(Constant.message));
			request.setAttribute(Constant.employeeId, resultMap.get(Constant.employeeId));
			request.setAttribute(Constant.employeeName, resultMap.get(Constant.employeeName));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
			if(custpreparedStatement!=null) {
					custpreparedStatement.close();
				}
			if(con!=null) {
					Constant.db.releaseDbConnection(con);
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}
}
