package com.training.demo.process;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;

public class ApplyLeave implements Command{
	@Override
	public Map<String, Object> execute(Map<String, String> mappingholder,HttpServletRequest request) 
	{
		Map<String, Object> resultMap = new HashMap<>();
		String empId=mappingholder.get("employeeId");
		String name=mappingholder.get("employeeName");
		System.out.println("employeeName^^^^^"+name);
		resultMap.put(Constant.uriPath, "success");
		resultMap.put(Constant.employeeId, empId);
		resultMap.put(Constant.employeeName, name);
		request.setAttribute(Constant.employeeId, resultMap.get(Constant.employeeId));
		request.setAttribute(Constant.employeeName, resultMap.get(Constant.employeeName));
		return resultMap;
	}	
}
