package com.AppDirect.Checkers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.AppDirect.Pages.EmailPage;
import com.AppDirect.BrowserSelect.BrowserDriver;

public class EmailPageChecker {
	public void CheckEmail(WebDriver driver) {
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Sign Up"));
		
	}
}
