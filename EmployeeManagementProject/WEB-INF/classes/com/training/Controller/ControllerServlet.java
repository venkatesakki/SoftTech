package com.training.Controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.training.commandFactory.CommandFactory;
import com.training.commandFactory.MappingHolder;
import com.training.iface.Command;

public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uriPath = request.getRequestURI();
		String[] uriSplit = uriPath.split("/");
		String reqPath = uriSplit[uriSplit.length-1];
		Command obj=CommandFactory.createCommand(reqPath);
		Map<String, String> map = new HashMap<>();
		String paramValues = null;
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements())
		{
			String paramName= paramNames.nextElement();
			paramValues=request.getParameter(paramName);
			map.put(paramName, paramValues);
		}
		if(obj!=null)
		{	
			String responsePath = obj.execute(map,request);
			MappingHolder mappings=CommandFactory.urlToMappingHolderMap.get(reqPath);
			Properties urlMappings=mappings.getPageMappings();
			String resultMap=urlMappings.getProperty(responsePath);
			RequestDispatcher dispatcher = request.getRequestDispatcher(resultMap);
			dispatcher.forward(request, response);
			
		}else {
			System.err.println("no mapping foud for identifier " + request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
