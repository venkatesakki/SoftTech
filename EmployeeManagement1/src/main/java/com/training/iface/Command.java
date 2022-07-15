package com.training.iface;

import java.util.Map;

public interface Command 
{
	public Map<String, Object> execute(Map<String, String> map);
}
