package com.training.demo.process;

import java.util.HashMap;
import java.util.Map;

import com.training.iface.Command;
import com.training.iface.Constant;

public class RegisterForm implements Command
{

	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		Map<String, Object> map2 = new HashMap<>();
		String uri = "Register.jsp";
		map2.put(Constant.uriPath, uri);
		return map2;
	}

}
