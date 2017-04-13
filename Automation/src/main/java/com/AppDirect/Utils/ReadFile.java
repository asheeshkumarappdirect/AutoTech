package com.AppDirect.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ReadFile {
	public Properties propertyFile(String fileName) throws IOException {
		Reporter.log("Reading properties file", false);
		
		FileInputStream fin = new FileInputStream(new File(fileName));
		Properties pr = new Properties();
		pr.load(fin);
		return pr;
	}
}
