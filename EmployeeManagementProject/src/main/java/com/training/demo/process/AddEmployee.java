package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class AddEmployee implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		int result=0;
		Map<String, Object> resultMap = new HashMap<>();
		PreparedStatement custpreparedStatement = null;
		try {
			System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
			con = Constant.db.getDbConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {		
		String employeeId = map.get(Constant.employeeId);
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
		String password = map.get(Constant.password);
		String roleType = map.get(Constant.roleType);
		String managerId;
		if(roleType.equalsIgnoreCase("employee")){
			 managerId = map.get("managerId1");
		}else {
			 managerId = map.get("managerId2");
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
				custpreparedStatement = con.prepareStatement(Constant.insertEmpEntity);
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
					
					String message="Successfully Registered";
					resultMap.put(Constant.message, message);
					request.setAttribute(Constant.message, resultMap.get(Constant.message));	
					resultMap.put(Constant.uriPath, "success");
					return resultMap;
				}else {
					String message="Error in Registering";
					resultMap.put(Constant.message, message);
					request.setAttribute(Constant.message, resultMap.get(Constant.message));	
					resultMap.put(Constant.uriPath, "error");
					return resultMap;
				}
			}else { 
				 
				String message="Already Exist";
				resultMap.put(Constant.message, message);
				request.setAttribute(Constant.message, resultMap.get(Constant.message));	
				resultMap.put(Constant.uriPath, "error");
				return resultMap;
				  }
			}else {
				 String message="Invalid Values";
			     resultMap.put(Constant.message, message);
			     request.setAttribute(Constant.message, resultMap.get(Constant.message));	
				 String uri = "error"; 
				 resultMap.put(Constant.uriPath, uri);
				}
		}else {
				String message="Invalid Values";
				resultMap.put(Constant.message, message);
				request.setAttribute(Constant.message, resultMap.get(Constant.message));	
				String uri = "error"; 
				resultMap.put(Constant.uriPath, uri);
				}
		}catch (SQLException e){
		    e.printStackTrace();
		}finally{
			try {
			if(custpreparedStatement!=null) {
					custpreparedStatement.close();
				}
			if(con!=null) {
				Constant.db.releaseDbConnection(con);
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}
}
