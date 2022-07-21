package com.training.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.training.iface.Constant;

public class FindEmployee 
{
	public static Employee findEmployeeById(String employee_id,Connection con){ 
		Employee emp = null;
		PreparedStatement pstm =null;
		try{
			pstm = con.prepareStatement(Constant.selectByEmployeeId);
			pstm.setString(1, employee_id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String employeeId = rs.getString(Constant.dbEmployeeId);
				String firstName=rs.getString(Constant.dbFirstName);
				String lastName=rs.getString(Constant.dbLastName);
				String password = rs.getString(Constant.dbpassword);
				String roleType=rs.getString(Constant.dbRoleType);
				emp = new Employee(employeeId, firstName, lastName, password, roleType);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				if(pstm!=null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
	  
	  return emp; 
	  }
}
