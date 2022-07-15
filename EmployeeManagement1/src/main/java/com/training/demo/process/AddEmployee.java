package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class AddEmployee implements Command
{

	Connection con = null;
	BasicConnectionPool bc = null;
	Employee emp = null;

	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Map<String, Object> map2 = new HashMap<>();
		String employeeId = map.get("employeeId");
		String firstName = map.get("firstName");
		String lastName = map.get("lastName");
		String gender = map.get("gender");
		int age = Integer.parseInt(map.get("age"));
		String address1 = map.get("address1");
		String address2 = map.get("address2");
		String city = map.get("city");
		String state = map.get("state");
		String country = map.get("country");
		int pinCode = Integer.parseInt(map.get("pinCode"));
		long phoneNumber = Long.parseLong(map.get("phoneNumber"));
		String email = map.get("email");
		String password = map.get("password");
		String roleType = map.get("roleType");
		String managerId = map.get("managerId");

		Employee empRes = FindEmployee.find(employeeId);
		
		if (empRes == null) {

			String uri = "login.jsp";
			map2.put(Constant.uriPath, uri);

			Employee emp = new Employee(employeeId, firstName, lastName, gender, age, address1, address2, city, state,
					country, pinCode, phoneNumber, email, password, roleType, managerId);

			String sql = "insert into user_entity (employee_id, first_name, last_name, gender, \n"
					+ "					age, address_line_1, address_line_2, city, state, country, pincode, \n"
					+ "					phone_number, email_id, password, role_type, manager_id)"
					+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement custpreparedStatement = null;
			try {
				custpreparedStatement = con.prepareStatement(sql);
				custpreparedStatement.setString(1, emp.getEmployeeId());
				custpreparedStatement.setString(2, emp.getFirstName());
				custpreparedStatement.setString(3, emp.getLastName());
				custpreparedStatement.setString(4, emp.getGender());
				custpreparedStatement.setInt(5, emp.getAge());
				custpreparedStatement.setString(6, emp.getAddress1());
				custpreparedStatement.setString(7, emp.getAddress2());
				custpreparedStatement.setString(8, emp.getCity());
				custpreparedStatement.setString(9, emp.getState());
				custpreparedStatement.setString(10, emp.getCountry());
				custpreparedStatement.setInt(11, emp.getPinCode());
				custpreparedStatement.setLong(12, emp.getPhoneNumber());
				custpreparedStatement.setString(13, emp.getEmail());
				custpreparedStatement.setString(14, emp.getPassword());
				custpreparedStatement.setString(15, emp.getRoleType());
				custpreparedStatement.setString(16, emp.getManagerId());

				custpreparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					custpreparedStatement.close();
					bc.releaseConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		  else { 
			  String uri = "alreadyexiterror.jsp"; map2.put(Constant.uriPath, uri);
			  }
		return map2;
	}
}
