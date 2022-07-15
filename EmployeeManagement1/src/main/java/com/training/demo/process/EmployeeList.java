package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class EmployeeList implements Command
{
	Connection con = null;
	BasicConnectionPool bc = null;
	Employee emp = null;
	Map<String, Object> map2 = new HashMap<>();
	List<Employee> list = new ArrayList<>();
	@Override
	public Map<String, Object> execute(Map<String, String> map) 
	{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			String empId = map.get(Constant.employeeId);
			map2.put(Constant.employeeId, empId);
			String uri = "EmployeeList.jsp";
			map2.put(Constant.uriPath, uri);
			
			
			String sql = "Select * from user_entity where manager_id=?";
			
			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, empId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					String employeeId = resultSet.getString("employee_id");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					String gender = resultSet.getString("gender");
					int age = resultSet.getInt("age");
					String address1 = resultSet.getString("address_line_1");
					String address2 = resultSet.getString("address_line_2");
					String city = resultSet.getString("city");
					String state = resultSet.getString("state");
					String country = resultSet.getString("country");
					int pinCode = resultSet.getInt("pincode");
					Long phoneNumber = resultSet.getLong("phone_number");
					String email = resultSet.getString("email_id");
					String password = resultSet.getString("password");
					String roleType=resultSet.getString("role_type");
					String managerId=resultSet.getString("manager_id");
				Employee employee=new Employee(employeeId, firstName, lastName, gender, 
						age, address1, address2, city, state, country, pinCode, 
						phoneNumber, email, password, roleType, managerId);
					list.add(employee);
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
				preparedStatement.close();
				con.close();
				resultSet.close();
				bc.releaseConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			map2.put(Constant.list, list);
			return map2;
	}
}
