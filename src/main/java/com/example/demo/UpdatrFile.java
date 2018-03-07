package com.example.demo;



import java.util.LinkedList;
import java.util.List;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class UpdatrFile {

	public static void main(String[] args) throws ConfigurationException {
	 List<String> l1=new LinkedList<>();
	 List<String> l2=new LinkedList<>();

	 l1.add("abc");
	 l1.add("pqr");
	 l1.add("rst");
	 l1.add("xyz");
	 System.out.println(l1);
	 for(int i=0;i<l1.size();i++)
	 {
		 if(i==0)
			l2.add("["+"\""+l1.get(i)+"\"");
		 else if(i==(l1.size()-1))
			l2.add("\""+l1.get(i)+"\""+"]");
		 else
			l2.add("\""+l1.get(i)+"\"");
 }
	 System.out.println(l2);

	Parameters params = new Parameters();
	FileBasedConfigurationBuilder<FileBasedConfiguration> builder =new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
		    .configure(params.properties()
		        .setFileName("C:/predixSDKs/PM_17.1.2_QA/configuration/machine/com.ge.dspmicro.hoover.spillway-4.config").setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
		Configuration config = builder.getConfiguration();
		/*config.setProperty("com.ge.dspmicro.hoover.spillway.dataSubscriptions", l2);
		builder.save();*/
	}

}
