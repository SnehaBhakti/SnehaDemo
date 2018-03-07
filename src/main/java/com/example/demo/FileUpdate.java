package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class FileUpdate {
	
	public static void main(String args[]) throws ConfigurationException
	{
		
		 
			
			PropertiesConfiguration config = new PropertiesConfiguration("C:/predixSDKs/PM_17.1.2_QA/configuration/machine/com.ge.dspmicro.hoover.spillway-4.config");
			config.setProperty("com.ge.dspmicro.hoover.spillway.name", "somevalue");
			config.save();		 
	}

}
