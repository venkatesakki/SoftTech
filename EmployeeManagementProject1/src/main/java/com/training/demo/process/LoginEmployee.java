package com.training.demo.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class LoginEmployee implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> mappingholder,HttpServletRequest request) {
		Connection con = null;
		
		Map<String, Object> resultMap = new HashMap<>();
		  try { 
			  System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			  System.out.println("add====" + con); 
		  } catch (SQLException e1) {
		  e1.printStackTrace(); 
		  }
		 
		String employeeId = mappingholder.get(Constant.employeeId);
		String password = mappingholder.get(Constant.password);		
		try{
			Employee empRes = FindEmployee.findEmployeeById(employeeId,con);
				if(empRes.getEmployeeId().equals(employeeId) && password.equals(empRes.getPassword())){
				if(empRes.getRoleType().equalsIgnoreCase("employee")){
				    StringBuilder name = new StringBuilder(empRes.getFirstName()).
				    		append(" ").append(empRes.getLastName());
					String message="Successfully LoggedIn";
					String uri = "successEmployee";
					System.out.println("Name@#$@#$"+name);
					resultMap.put(Constant.message, message);
					resultMap.put(Constant.employeeId, employeeId);
					resultMap.put(Constant.employeeName,name);
					resultMap.put(Constant.uriPath, uri);
					
					request.setAttribute(Constant.message, resultMap.get(Constant.message));
					request.setAttribute(Constant.employeeId, resultMap.get(Constant.employeeId));
					request.setAttribute(Constant.employeeName, resultMap.get(Constant.employeeName));
					
					return resultMap;
					}else if(empRes.getRoleType().equalsIgnoreCase("manager")){
					String message="Successfully LoggedIn";
					resultMap.put(Constant.message, message);
					String uri = "successManager";
					resultMap.put(Constant.employeeId, employeeId);
					resultMap.put(Constant.uriPath, uri);
					request.setAttribute(Constant.message, resultMap.get(Constant.message));
					request.setAttribute(Constant.employeeId, resultMap.get(Constant.employeeId));
					return resultMap;
					}
				}else{
					String uri = "error"; 
					String message="Invalid UserName or Password";
					resultMap.put(Constant.message, message);
					resultMap.put(Constant.uriPath, uri);
					request.setAttribute(Constant.message, resultMap.get(Constant.message));
					return resultMap;
					}
		}catch (Exception e1){
			e1.printStackTrace();
		}finally{
			if(con!=null){
				Constant.db.releaseDbConnection(con);
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}return resultMap;
	}
}
