package com.training.demo.process;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;

public class PaySlipForm implements Command{
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Map<String, Object> resultMap = new HashMap<>();

		resultMap.put(Constant.uriPath, "success");
		return resultMap;
	}
}
