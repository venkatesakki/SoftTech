package com.training.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.training.iface.Constants;

public class FindEmployee 
{
	public static Employee findEmployeeById(String employee_id,Connection con){ 
		Employee emp = null;
		PreparedStatement pstm =null;
		try{
			pstm = con.prepareStatement(Constants.SELECT_BY_EMP_ID);
			pstm.setString(1, employee_id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				String employeeId = rs.getString(Constants.DB_EMPLOYEE_ID);
				String firstName=rs.getString(Constants.DB_FIRST_NAME);
				String lastName=rs.getString(Constants.DB_LAST_NAME);
				String password = rs.getString(Constants.DB_PASSWORD);
				String roleType=rs.getString(Constants.DB_ROLE_TYPE);
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
