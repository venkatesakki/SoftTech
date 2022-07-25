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

public class LeaveList implements Command
{
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		Map<String, Object> resultMap = new HashMap<>();
		List<LeaveEntity> leaveList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			String empId = map.get(Constant.employeeId);
			resultMap.put(Constant.employeeId, empId);
			String uri = "success";
			resultMap.put(Constant.uriPath, uri);
			
			try {
				preparedStatement = con.prepareStatement(Constant.viewleaveEntityBymanagerId);
				preparedStatement.setString(1, empId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					int serialNo=resultSet.getInt("serial_no");
					String employeeId = resultSet.getString("employee_id");
					String employeeName = resultSet.getString("employee_name");
					String fromDate = resultSet.getString("from_date");
					String toDate = resultSet.getString("to_date");
					String reason = resultSet.getString("reason");
					String managerId = resultSet.getString("manager_id");
					String status = resultSet.getString("status");
					LeaveEntity leave=new LeaveEntity(serialNo,employeeId, employeeName, 
						fromDate, toDate, reason, managerId, status);
					leaveList.add(leave);
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
		
			resultMap.put(Constant.list, leaveList);
			request.setAttribute(Constant.list, resultMap.get(Constant.list));
			return resultMap;
	}
}
