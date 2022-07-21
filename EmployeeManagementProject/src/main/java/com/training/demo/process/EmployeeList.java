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
import com.training.model.Employee;


public class EmployeeList implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		Map<String, Object> resultMap = new HashMap<>();
		List<Employee> employeeList = new ArrayList<>();
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			String empId = map.get(Constant.employeeId);
			System.out.println("empId----------------"+empId);
			resultMap.put(Constant.employeeId, empId);
			String uri = "success";
			resultMap.put(Constant.uriPath, uri);
			
			try {
				preparedStatement = con.prepareStatement(Constant.viewEmployeeBymanagerId);
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
					employeeList.add(employee);
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
			resultMap.put(Constant.list, employeeList);
			request.setAttribute(Constant.list, resultMap.get(Constant.list));
			return resultMap;
	}
}
