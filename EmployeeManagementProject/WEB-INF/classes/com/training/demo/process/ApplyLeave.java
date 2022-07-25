package com.training.demo.process;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;

public class ApplyLeave implements Command{
	@Override
	public String execute(Map<String, String> mappingholder,HttpServletRequest request){
		String empId=mappingholder.get("employeeId");
		String name=mappingholder.get("employeeName");
		
		request.setAttribute(Constants.EMPLOYEE_ID,empId );
		request.setAttribute(Constants.EMPLOYEE_NAME, name);
		return Constants.SUCCESS;
	}	
}
