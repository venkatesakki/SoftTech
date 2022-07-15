package com.training.demo.process;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.FindEmployee;

public class WelcomeEmployee implements Command
{
	Connection con = null;
	BasicConnectionPool bc = null;
	Employee emp = null;
	Map<String, Object> map2 = new HashMap<>();
	@Override
	public Map<String, Object> execute(Map<String, String> map) 
	{
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		String employeeId = map.get(Constant.employeeId);
		String password = map.get(Constant.password);

				
		try 
		{
			Employee empRes = FindEmployee.find(employeeId);
			if(empRes.getEmployeeId().equals(employeeId) && password.equals(empRes.getPassword()))
			{
				if(empRes.getRoleType().equalsIgnoreCase("employee")) 
				{
					String uri = "EmployeeDashboard.jsp";
					map2.put(Constant.employeeId, employeeId);
					map2.put(Constant.uriPath, uri);
					return map2;
				}
				else if(empRes.getRoleType().equalsIgnoreCase("manager"))
				{
					String uri = "SupervisorDashboard.jsp";
					map2.put(Constant.employeeId, employeeId);
					map2.put(Constant.uriPath, uri);
					return map2;
				}

			}
			else 
			{
				String uri = "invaliderror.jsp"; 
				map2.put(Constant.uriPath, uri);
				return map2;
			}
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
			String uri = "invaliderror.jsp"; 
			map2.put(Constant.uriPath, uri);
			return map2;
		}
		finally 
		{
			bc.releaseConnection(con);
		}
		return map2;
	}

}
