package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;
import com.training.model.LeaveEntity;

public class LeaveList implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		List<LeaveEntity> leaveList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String empId=null;
		try {
			con = Constants.DB.getDbConnection();
			empId = map.get(Constants.EMPLOYEE_ID);
			preparedStatement = con.prepareStatement(Constants.VIEW_LEAVE_ENTITY_BY_MANAGER_ID);
			preparedStatement.setString(1, empId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
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
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(resultSet!=null) {
					resultSet.close();
				}if(preparedStatement!=null) {
					preparedStatement.close();
				}if(con!=null) {
					Constants.DB.releaseDbConnection(con);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}request.setAttribute(Constants.EMPLOYEE_ID, empId);
		 request.setAttribute(Constants.LIST, leaveList);
		 return Constants.SUCCESS;
	}
}
