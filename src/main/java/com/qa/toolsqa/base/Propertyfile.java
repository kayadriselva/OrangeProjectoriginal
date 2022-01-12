package com.qa.toolsqa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile {
	
	static Properties prop;
	public static Properties propertyfileinit(String propertyfilepath)
	{
		try
		{
		prop= new Properties();
		FileInputStream ip = new FileInputStream(propertyfilepath);
		prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}			
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;	
	}
	

}
