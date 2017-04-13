package com.AppDirect.Checkers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.AppDirect.Pages.SignUpPage;

public class SignUpPageChecker {
	public void CheckSignUp(WebDriver driver) {
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("AppDirect"));
	}
}
