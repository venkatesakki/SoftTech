package com.training.commandFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.training.iface.Command;

public class CommandFactory 
{
	public static Map<String,MappingHolder> urlToMappingHolderMap=new HashMap<>();	
	static {
		Properties mappings=new Properties();
		try {
			InputStream inputStream = null;
			ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
			inputStream = classLoader.getResourceAsStream("utils/command.properties");
			if(inputStream!=null) {
			mappings.load(inputStream);
			inputStream.close();
			
			}else {
				System.err.println("unable to open the file");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		@SuppressWarnings("rawtypes")
		Iterator mappingIter=mappings.keySet().iterator();
		while(mappingIter.hasNext()) {
			String oneKey=(String)mappingIter.next();
			String mappedValue=mappings.getProperty(oneKey);
			MappingHolder oneHolder=new MappingHolder();
			String[] mappedValueArr=mappedValue.split("::");
			oneHolder.setClassName(mappedValueArr[0]);
			oneHolder.setUrl(oneKey);
			if(mappedValueArr.length>1) {
			String[] returnUrlArr=	mappedValueArr[1].split(",");
			for (String oneUrlMapping: returnUrlArr) {
				String[] parts=oneUrlMapping.split(":");
				oneHolder.getPageMappings().setProperty(parts[0], parts[1]);				
				}
			}
			urlToMappingHolderMap.put(oneKey,oneHolder);			
		}
		System.out.println("url mappings======"+urlToMappingHolderMap);
	}
	
	public static Command createCommand(String identifier) {
		MappingHolder oneHolder=urlToMappingHolderMap.get(identifier);	
		Command commandObj=null;
		if(oneHolder==null){
			System.err.println("no mapping found for identifier " + identifier);
			return null;
		}else {			
			String className=oneHolder.getClassName();		
			
			try {
				Class clz=Class.forName(className);
				try {
					commandObj=(Command)	clz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {				
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}
		}
		return commandObj;		
	}
}
