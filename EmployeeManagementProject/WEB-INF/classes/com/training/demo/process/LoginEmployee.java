package com.training.demo.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class LoginEmployee implements Command
{
	@Override
	public String execute(Map<String, String> mappingholder,HttpServletRequest request) {
		Connection con = null;
	 try {
		con = Constants.DB.getDbConnection();
		String employeeId = mappingholder.get(Constants.EMPLOYEE_ID);
		String password = mappingholder.get(Constants.PASSWORD);
		Employee empRes = FindEmployee.findEmployeeById(employeeId,con);
		if(empRes!=null) {
			if(empRes.getEmployeeId().equals(employeeId) && password.equals(empRes.getPassword())){
			if(empRes.getRoleType().equalsIgnoreCase("employee")){
			    StringBuilder name = new StringBuilder(empRes.getFirstName()).
			    		append(" ").append(empRes.getLastName());
				String uri = "successEmployee";
				request.setAttribute(Constants.MESSAGE, "Successfully LoggedIn");
				request.setAttribute(Constants.EMPLOYEE_ID, employeeId);
				request.setAttribute(Constants.EMPLOYEE_NAME, name);
				
				return uri;
			}else if(empRes.getRoleType().equalsIgnoreCase("manager")){
				String uri = "successManager";
				request.setAttribute(Constants.MESSAGE, "Successfully LoggedIn");
				request.setAttribute(Constants.EMPLOYEE_ID, employeeId);
				return uri;
				}
			}else{
				request.setAttribute(Constants.MESSAGE, "Invalid UserName or Password");
				return Constants.ERROR;
				}
		}else {
			request.setAttribute(Constants.MESSAGE, "Invalid UserName or Password");
			return Constants.ERROR;
		}
		}catch (SQLException e1){
			e1.printStackTrace();
		}finally{
			if(con!=null){
				Constants.DB.releaseDbConnection(con);
			}
		}return null;
	}
}
