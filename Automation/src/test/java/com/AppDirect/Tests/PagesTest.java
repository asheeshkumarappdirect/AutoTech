package com.AppDirect.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AppDirect.BrowserSelect.BrowserChoice;
import com.AppDirect.BrowserSelect.BrowserDriver;
import com.AppDirect.Pages.EmailPage;
import com.AppDirect.Pages.HomePage;
import com.AppDirect.Pages.SignUpPage;
import com.AppDirect.exceptions.FileNotFoundException;
import com.AppDirect.Checkers.BrowserChecker;
import com.AppDirect.Checkers.EmailPageChecker;
import com.AppDirect.Checkers.HomePageChecker;
import com.AppDirect.Checkers.SignUpPageChecker;


public class PagesTest{
	
	WebDriver driver;
	SignUpPage signup;
	EmailPage email;
	String browser;
	
	@BeforeClass
	public void StartBrowser() throws IOException {
		Reporter.log("Starting browser", true);
		
		BrowserDriver browserDriver = PageFactory.initElements(driver, BrowserDriver.class);
		driver = browserDriver.driver();
	}
	
	@Test(priority = 1)
	public void  HomePageTest() throws IOException, FileNotFoundException {		
		HomePage homePage =new 	HomePage (driver);

		signup = homePage
				.HomePageBehaviour()
				.logIn();	
	}
		
	@Test(priority = 2)
	public void SignUpPageTest() throws IOException, FileNotFoundException {
		Reporter.log("Testing SignUpPage", true);
		
		email = signup	
				.SignUpPageBehaviour()
				.signUp();
	}
	
	@Test(priority = 3)
	public void EmailPage() throws IOException {
		Reporter.log("Testing EmailPage", true);
		
		email.EmailPageBehaviour()
				.Email();
				
	}
	
	@Test(priority = 4) 
	public void NewRegistration() throws IOException {
	email.NewEmail();
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException {
		Reporter.log("Closing the browser");		

		driver.quit();
	}
	
}
