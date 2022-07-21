package com.training.iface;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface Command
{
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request);
}
