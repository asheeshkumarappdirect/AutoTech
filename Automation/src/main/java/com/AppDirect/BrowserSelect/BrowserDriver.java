package com.AppDirect.BrowserSelect;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.AppDirect.BrowserSelect.SupportedBrowser;
import com.AppDirect.Checkers.BrowserChecker;

public class BrowserDriver {
	WebDriver driver;
	BrowserChoice browserChoice;
	String browser;

	public WebDriver driver() throws IOException {
		
		browser = CallBrowserChoice();
		
		CheckBrowser(browser);
		
		if(SupportedBrowser.CHROME.toString().equalsIgnoreCase(browser)) {
			Reporter.log("Selected ChromeBrowser", false);
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		else if(SupportedBrowser.FIREFOX.toString().equalsIgnoreCase(browser)) {
			Reporter.log("Selected FirefoxBrowser", false);
			System.setProperty("webdriver.gecko.driver","geckodriver");
			driver = new FirefoxDriver();
		}
		
		else {
			Reporter.log("Selected DefaultBrowser: Chrome", false);
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	String CallBrowserChoice() throws IOException {
		String br;
		browserChoice = new BrowserChoice();
		br = browserChoice.BrowserSelection();	
		return br;
	}
	
	public void CheckBrowser(String browser) {
		BrowserChecker browserChecker = new BrowserChecker();
		browserChecker.CheckBrowser(browser);
	}
	
}
