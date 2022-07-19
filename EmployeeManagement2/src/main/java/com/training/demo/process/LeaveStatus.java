package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.LeaveEntity;

public class LeaveStatus implements Command
{
	Connection con = null;
	BasicConnectionPool bc = null;
	Map<String, Object> map2 = new HashMap<>();
	List<LeaveEntity> list = new ArrayList<>();
	@Override
	public Map<String, Object> execute(Map<String, String> map) 
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			String empId = map.get(Constant.employeeId);
			map2.put(Constant.employeeId, empId);
			String uri = "leaveStatus.jsp";
			map2.put(Constant.uriPath, uri);
			
			
			String sql = "Select * from leave_entity where employee_id=?";
			
			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, empId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					String employeeId = resultSet.getString("employee_id");
					String employeeName = resultSet.getString("employee_name");
					String fromDate = resultSet.getString("from_date");
					String toDate = resultSet.getString("to_date");
					String reason = resultSet.getString("reason");
					String managerId = resultSet.getString("manager_id");
					String status = resultSet.getString("status");
					LeaveEntity leave=new LeaveEntity(employeeId, employeeName, 
						fromDate, toDate, reason, managerId, status);
					list.add(leave);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
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
				resultSet.close();
				bc.releaseConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			map2.put(Constant.list, list);
			return map2;
	}
}
