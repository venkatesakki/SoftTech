package com.training.demo.process;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;


public class RegisterForm implements Command{
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Map<String, Object> map2 = new HashMap<>();
		map2.put(Constant.uriPath, "success");
		return map2;
	}
}
