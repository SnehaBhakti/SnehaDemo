package com.example.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfig {
	
	 public static void main( String[] args )
	    {
	    	Properties prop = new Properties();
	 
	    	try {
	    		//set the properties value
	    		StringBuilder sb = new StringBuilder();
	    		sb.append('"').append("sneha").append('"');
	    		prop.setProperty("name", sb.toString());
	    		sb.delete(0, sb.length());
	    		sb.append('"').append("user").append('"');
	    		prop.setProperty("dbuser", sb.toString());
	    		sb.delete(0, sb.length());
	    		sb.append('"').append("abcde").append('"');
	    		prop.setProperty("dbpassword", sb.toString());
	 
	    		//save properties to project root folder
	    		prop.store(new FileOutputStream("C://Sneha//sneha.config"), null);
	 
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
	    }

}
