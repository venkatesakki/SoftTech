package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.training.iface.Command;
import com.training.iface.Constants;
public class AddLeave implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		HttpSession httpSession = request.getSession(); 
		PreparedStatement custpreparedStatement = null;
		 try { 
			con = Constants.DB.getDbConnection();
			String employeeId = map.get(Constants.EMPLOYEE_ID);
			String employeeName = map.get("employeeName");
			String fromDate =map.get("fromDate");
			String toDate = map.get("toDate");
			String reason = map.get("reason");
			String managerId = map.get("managerId");
			String status = map.get("status");
			
			custpreparedStatement = con.prepareStatement(Constants.INSERT_LEAVE_ENTITY);
			custpreparedStatement.setString(1, employeeId);
			custpreparedStatement.setString(2, employeeName);
			custpreparedStatement.setString(3, fromDate);
			custpreparedStatement.setString(4, toDate);
			custpreparedStatement.setString(5, reason);
			custpreparedStatement.setString(6, managerId);
			custpreparedStatement.setString(7, status);
			custpreparedStatement.executeUpdate();
	
			httpSession.setAttribute(Constants.MESSAGE, "Submited Successfully");
			request.setAttribute(Constants.EMPLOYEE_ID, employeeId);
			request.setAttribute(Constants.EMPLOYEE_NAME, employeeName);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					if(custpreparedStatement!=null){
							custpreparedStatement.close();
					  }
					if(con!=null){
							Constants.DB.releaseDbConnection(con);
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}return Constants.SUCCESS;
	}
}
