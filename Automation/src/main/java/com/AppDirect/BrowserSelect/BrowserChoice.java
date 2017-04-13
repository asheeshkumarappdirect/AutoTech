package com.AppDirect.BrowserSelect;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.testng.Reporter;

import com.AppDirect.Utils.ReadFile;

public class BrowserChoice {

	public String BrowserSelection() throws IOException {
		
		String browser = System.getProperty("browser");
		
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("browser.properties");
		
		if(browser == null) {
			browser = pr.getProperty("browser");
		}
		return browser;
	}
}