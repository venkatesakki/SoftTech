package com.training.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import com.training.connection.ConnectionClass;
import com.training.iface.Command;
import com.training.iface.TravelConstant;
import com.training.model.Employee;

public class AddEmployee implements Command
{

	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		
		Connection con=ConnectionClass.getPostgresConnection();
		Map<String, Object> map2 = new HashMap<>();
		String uri = "EmployeeLogin.jsp";
		map2.put(TravelConstant.uriPath, uri);
		String firstName=map.get("firstName");
		String lastName=map.get("lastName");
		String gender=map.get("gender");
		int age=Integer.parseInt(map.get("age"));
		long phoneNumber=Long.parseLong(map.get("phoneNumber"));
		String email=map.get("email");
		String userName=map.get("userName");
		String password=map.get("password");
		String employeehead=map.get("employeehead");
		Employee emp=new Employee(firstName, lastName, gender, age, phoneNumber,
				email, userName, password, employeehead);
		String sql="insert into register (firstname,lastname,gender,age,"
				+ "phonenumber,email,username,password,employeehead) values(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement custpreparedStatement = null;
		 try {
			custpreparedStatement = con.prepareStatement(sql);
			custpreparedStatement.setString(1, emp.getFirstName());
			custpreparedStatement.setString(2, emp.getLastName());
			custpreparedStatement.setString(3, emp.getGender());
			custpreparedStatement.setInt(4, emp.getAge());
			custpreparedStatement.setLong(5, emp.getPhoneNumber());
			custpreparedStatement.setString(6, emp.getEmail());
			custpreparedStatement.setString(7, emp.getUserName());
			custpreparedStatement.setString(8, emp.getPassword());
			custpreparedStatement.setString(9, emp.getEmployeehead());
			custpreparedStatement.executeUpdate();
		 }
		 catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					custpreparedStatement.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return map2;
	}

}
