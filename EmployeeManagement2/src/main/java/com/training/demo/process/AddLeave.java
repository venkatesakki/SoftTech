package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;
import com.training.model.LeaveEntity;

public class AddLeave implements Command
{

	Connection con = null;
	BasicConnectionPool bc = null;
	LeaveEntity leave = null;
	int result=0;
	@Override
	public Map<String, Object> execute(Map<String, String> map) 
	{
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Map<String, Object> map2 = new HashMap<>();
		String employeeId = map.get("employeeId");
		String employeeName = map.get("employeeName");
		String fromDate =map.get("fromDate");
		String toDate = map.get("toDate");
		String reason = map.get("reason");
		String managerId = map.get("managerId");
		String status = map.get("status");
		LeaveEntity leave=new LeaveEntity(employeeId, employeeName, fromDate, toDate, reason, managerId, status);
	
			String sql = "insert into leave_entity (employee_id, employee_name,from_date,to_date"
					+ ",reason, manager_id,status) values(?,?,?,?,?,?,?)";

			PreparedStatement custpreparedStatement = null;
			try {
				custpreparedStatement = con.prepareStatement(sql);
				custpreparedStatement.setString(1, leave.getEmployeeId());
				custpreparedStatement.setString(2, leave.getEmployeeName());
				custpreparedStatement.setString(3, leave.getFromDate());
				custpreparedStatement.setString(4, leave.getToDate());
				custpreparedStatement.setString(5, leave.getReason());
				custpreparedStatement.setString(6, leave.getManagerId());
				custpreparedStatement.setString(7, leave.getStatus());
				result=custpreparedStatement.executeUpdate();
				if(result>0) 
				{
					String message="Successfully Registered";
					map2.put(Constant.message, message);
					String uri = "EmployeeDashboard.jsp";
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
				try 
				{
					custpreparedStatement.close();
					bc.releaseConnection(con);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		return map2;
	}

}
