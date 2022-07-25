package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.LeaveEntity;

public class ViewLeave implements Command
{
	
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		Map<String, Object> resultMap = new HashMap<>();
		LeaveEntity leaveEntity = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			int serialNum = Integer.parseInt(map.get("serialNo"));
			System.out.println("Serial*************"+serialNum);
			String uri = "success";
			resultMap.put(Constant.uriPath, uri);
			
			try {
				preparedStatement = con.prepareStatement(Constant.viewleaveEntityBySerialNo);
				preparedStatement.setInt(1, serialNum);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) 
				{
					int serialNo=resultSet.getInt("serial_no");
					String employeeId = resultSet.getString("employee_id");
					String employeeName = resultSet.getString("employee_name");
					String fromDate = resultSet.getString("from_date");
					String toDate = resultSet.getString("to_date");
					String reason = resultSet.getString("reason");
					String managerId = resultSet.getString("manager_id");
					String status = resultSet.getString("status");
					leaveEntity=new LeaveEntity(serialNo,employeeId, employeeName, 
						fromDate, toDate, reason, managerId, status);
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
		
			resultMap.put(Constant.leaveObject,leaveEntity);
			request.setAttribute(Constant.leaveObject, resultMap.get(Constant.leaveObject));
			return resultMap;
	}

}

