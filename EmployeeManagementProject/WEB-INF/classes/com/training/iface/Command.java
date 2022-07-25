package com.training.iface;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface Command
{
	public String execute(Map<String, String> map,HttpServletRequest request);
}
