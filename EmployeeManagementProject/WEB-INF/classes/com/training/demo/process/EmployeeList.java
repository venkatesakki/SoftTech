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
import com.training.model.Employee;


public class EmployeeList implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request){
		Connection con = null;
		List<Employee> employeeList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String empId=null;
		try {
			con = Constants.DB.getDbConnection();
			empId = map.get(Constants.EMPLOYEE_ID);
			
			preparedStatement = con.prepareStatement(Constants.VIEW_EMP_BY_MANAGER_ID);
			preparedStatement.setString(1, empId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
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
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		 request.setAttribute(Constants.LIST, employeeList);
		 return Constants.SUCCESS;
	}
}
