package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.AppDirect.Checkers.SignUpPageChecker;
import com.AppDirect.Utils.ReadFile;
import com.AppDirect.exceptions.FileNotFoundException;

public class SignUpPage {
	WebDriver driver;
	String xpath;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignUpPage SignUpPageBehaviour() throws IOException, FileNotFoundException {
		
		SignUpPageChecker signUpPageChecker = new SignUpPageChecker();
		signUpPageChecker.CheckSignUp(driver);
		
		Reporter.log("SignUpPage", false);
		
		return new SignUpPage(driver);
	}
	
	public EmailPage signUp() throws IOException {
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("SignUp.properties");
		String xpath = pr.getProperty("xpath");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	     
		driver.findElement(By.xpath(xpath)).click();
		return new EmailPage(driver);
	}
	
}
