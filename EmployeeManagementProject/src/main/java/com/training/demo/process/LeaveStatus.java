package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.LeaveEntity;

public class LeaveStatus implements Command
{
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		Map<String, Object> resultMap = new HashMap<>();
		List<LeaveEntity> leaveEntityList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String empId = null;
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			empId=map.get(Constant.employeeId);
			System.out.println("!!!!!!!!!!!!"+empId);
			try {
				preparedStatement = con.prepareStatement(Constant.leaveEntityById);
				preparedStatement.setString(1, empId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					String employeeId = resultSet.getString(Constant.dbEmployeeId);
					String employeeName = resultSet.getString("employee_name");
					String fromDate = resultSet.getString("from_date");
					String toDate = resultSet.getString("to_date");
					String reason = resultSet.getString("reason");
					String managerId = resultSet.getString("manager_id");
					String status = resultSet.getString("status");
					LeaveEntity leave=new LeaveEntity(employeeId, employeeName, 
						fromDate, toDate, reason, managerId, status);
					leaveEntityList.add(leave);
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
				if(con!=null) {
					Constant.db.releaseDbConnection(con);
					con.close();
				}if(preparedStatement!=null) {
					preparedStatement.close();
				}if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String uri = "success";
		resultMap.put(Constant.uriPath, uri);
		resultMap.put(Constant.list, leaveEntityList);
		request.setAttribute(Constant.list, resultMap.get(Constant.list));
		
		return resultMap;
	}
}
