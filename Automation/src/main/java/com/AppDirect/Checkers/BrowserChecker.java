package com.AppDirect.Checkers;

import org.testng.Reporter;

import com.AppDirect.BrowserSelect.BrowserDriver;

public class BrowserChecker {
	public void  CheckBrowser(String browser) {
		
		if(browser == null) {
			throw new NullPointerException("Browser not found");
		}
		else {
			Reporter.log("Browser found!");
		}
	}
}
