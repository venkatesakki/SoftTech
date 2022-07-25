package com.training.demo.process;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.training.iface.Command;
import com.training.iface.Constants;


public class LoginForm implements Command{
	
	@Override
	public String execute(Map<String, String> mappingholder,HttpServletRequest request) {
		HttpSession session= request.getSession();
		session.invalidate();
		return Constants.SUCCESS;
	}
}
