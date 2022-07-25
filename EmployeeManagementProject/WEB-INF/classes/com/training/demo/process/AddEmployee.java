package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class AddEmployee implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		int result=0;
		PreparedStatement custpreparedStatement = null;
		try {
			con = Constants.DB.getDbConnection();
			con.setAutoCommit(false);
			String employeeId = map.get(Constants.EMPLOYEE_ID);
			String firstName = map.get("firstName");
			String lastName = map.get("lastName");
			String gender = map.get("gender");
			int age =Integer.parseInt(map.get("age"));
			String address1 = map.get("address1");
			String address2 = map.get("address2");
			String city = map.get("city");
			String state = map.get("state");
			String country = map.get("country");
			String email = map.get("email");
			String password = map.get(Constants.PASSWORD);
			String roleType = map.get(Constants.ROLE_TYPE);
			String managerId;
			if(roleType.equalsIgnoreCase("employee")){
				 managerId = map.get("managerId");
			}else {
				 managerId = "MD";
			}
			int pinCode = Integer.parseInt(map.get("pinCode"));
			long phoneNumber = Long.parseLong(map.get("phoneNumber"));
			String pin=map.get("pinCode");
			char[] Charpincode=pin.toCharArray();
			int pinValue=Charpincode.length;
			
			String phn=map.get("phoneNumber");
			char[] Charphn=phn.toCharArray();
			int phnValue=Charphn.length;
		
			if(age>18 && age<=60 && pinValue==6 && pinCode>0 && phoneNumber>0 && phnValue==10) {
				if(employeeId!=null) {
					Employee empRes = FindEmployee.findEmployeeById(employeeId,con);
					if (empRes == null ) {	
						Employee empRoleType = FindEmployee.findEmployeeById(managerId,con);
						if((roleType.equals("employee") && empRoleType.getRoleType().equals("manager")) ||
								(roleType.equals("manager"))){
							custpreparedStatement = con.prepareStatement(Constants.INSERT_EMP_ENTITY);
							custpreparedStatement.setString(1, employeeId);
							custpreparedStatement.setString(2, firstName);
							custpreparedStatement.setString(3,lastName);
							custpreparedStatement.setString(4, gender);
							custpreparedStatement.setInt(5, age);
							custpreparedStatement.setString(6, address1);
							custpreparedStatement.setString(7, address2);
							custpreparedStatement.setString(8, city);
							custpreparedStatement.setString(9, state);
							custpreparedStatement.setString(10, country);
							custpreparedStatement.setInt(11, pinCode);
							custpreparedStatement.setLong(12, phoneNumber);
							custpreparedStatement.setString(13,email);
							custpreparedStatement.setString(14, password);
							custpreparedStatement.setString(15, roleType);
							custpreparedStatement.setString(16,managerId);
							
							result=custpreparedStatement.executeUpdate();
							if(result>0) {
								request.setAttribute(Constants.MESSAGE,"Successfully Registered");
								return Constants.SUCCESS;
							}else {
								request.setAttribute(Constants.MESSAGE,"Error in Registering");	
								return Constants.ERROR;
							}
						}else {
							request.setAttribute(Constants.MESSAGE, "Invalid ManagerId");	
							return Constants.ERROR;
							  }
							}else {
						        request.setAttribute(Constants.MESSAGE, "Already Exist");	
						        return Constants.ERROR;
							}
						}else {
						     request.setAttribute(Constants.MESSAGE, "Invalid Values");
						     return Constants.ERROR;
							}
				}else {
						request.setAttribute(Constants.MESSAGE, "Invalid Values");	
						return Constants.ERROR;
						}
				}catch (SQLException e){
				    e.printStackTrace();
				    try {
						con.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}finally{
					
					try {
						if(custpreparedStatement!=null) {
								custpreparedStatement.close();
							}
						if(con!=null) {
							con.commit();
							Constants.DB.releaseDbConnection(con);
						 }
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		return null;
	}
}
