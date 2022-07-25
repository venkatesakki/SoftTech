package com.training.demo.process;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;


public class RegisterForm implements Command{
	
	@Override
	public String execute(Map<String, String> mappingholder,HttpServletRequest request) {
		return Constants.SUCCESS;
	}
}
