package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.AppDirect.Checkers.HomePageChecker;
import com.AppDirect.Utils.ReadFile;
import com.AppDirect.exceptions.FileNotFoundException;

public class HomePage {
	String url;
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage HomePageBehaviour() throws IOException, FileNotFoundException {
		
		HomePageChecker homePageChecker = new HomePageChecker();
		homePageChecker.CheckHomePage(driver);
		
		Reporter.log("HomePage", true);

		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("HomePage.properties");
		url=pr.getProperty("url");
		driver.get(url);
		return new HomePage(driver);
	}
	
	public SignUpPage logIn() throws IOException {		
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("HomePage.properties");
		String xpath = pr.getProperty("xpath");
		driver.findElement(By.xpath(xpath)).click();
		return new SignUpPage(driver);
	}
}
