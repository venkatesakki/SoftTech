package com.training.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connectionPool.BasicConnectionPool;
import com.training.factory.Factory;
import com.training.iface.Command;
import com.training.iface.Constant;

/**
 * Servlet implementation class EmployeeServlet
 */
//@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Properties properties = null; 
	BasicConnectionPool bc=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
	
		super.init();
		
		try
		{
			bc=BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro"
					, "postgres", "postgres");
			bc.getConnection();
		} 
		catch (SQLException e1) 
		{
			System.out.println("Connection Error");
			e1.printStackTrace();
		}
		InputStream inputStream = null;
		ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
		inputStream = classLoader.getResourceAsStream("command.properties");
		properties = new Properties();
		try 
		{ 
			properties.load(inputStream);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				inputStream.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		try
		{
			bc.shutdown();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uriPath = request.getRequestURI();
		String[] uriSplit = uriPath.split("/");
		String reqPath = uriSplit[uriSplit.length-1];
		boolean result = reqPath.endsWith(".in");
		
		if(result)
		{
			
			Map<String, String> map = new HashMap<>();
			String paramValues = null;
			Enumeration<String> paramNames = request.getParameterNames();
				
			while(paramNames.hasMoreElements())
			{
				String paramName= paramNames.nextElement();
				paramValues=request.getParameter(paramName);
				map.put(paramName, paramValues);
			}
			
			String classPackageName = properties.getProperty(reqPath);
			Command command = Factory.getClass(classPackageName);
			Map<String,Object> map1 = command.execute(map);
			
			String responsePath = (String) map1.get(Constant.uriPath);
			
			request.setAttribute("list", map1.get(Constant.list));			  
			request.setAttribute("leave",map1.get(Constant.object));
			request.setAttribute("message", map1.get(Constant.message));
			HttpSession httpSession = request.getSession();
			  
			if(map1.get(Constant.employeeId)!=null)
			{ 
				httpSession.setAttribute("empId",map1.get(Constant.employeeId)); 
			}
			if(responsePath!=null)
			{
				System.out.println(map1.get(Constant.message));
				RequestDispatcher dispatcher = request.getRequestDispatcher(responsePath);
				dispatcher.forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("error").forward(request, response);
			}
		}
		else
		{
			String responsePath = properties.getProperty(reqPath);
			if(responsePath!=null)
			{
				request.getRequestDispatcher(responsePath).forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("error").forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
