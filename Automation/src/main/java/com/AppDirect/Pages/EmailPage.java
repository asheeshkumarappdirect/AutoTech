package com.AppDirect.Pages;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.AppDirect.Checkers.EmailPageChecker;
import com.AppDirect.Utils.ReadFile;

public class EmailPage {
	
	WebDriver driver;
	String inputxpath, buttonxpath, email;
	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
	}

	public EmailPage EmailPageBehaviour() throws IOException {
		EmailPageChecker emailPageChecker = new EmailPageChecker();
		emailPageChecker.CheckEmail(driver);

		return new EmailPage(driver);
	}
	
	public EmailPage Email() throws IOException {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);  
		String emailId = "username"+ randomInt +"@gmail.com";
		
		Reporter.log("Email page", false);
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("EmailPage.properties");
		inputxpath = pr.getProperty("inputxpath");
		buttonxpath= pr.getProperty("buttonxpath");	
		
		driver.findElement(By.xpath(inputxpath)).sendKeys(emailId);

		driver.findElement(By.name("userSignupButton")).click();
		
		return new EmailPage(driver);
	}
	
	public EmailPage NewEmail() throws IOException {
		ReadFile read = new ReadFile();
		Properties pr = read.propertyFile("EmailPage.properties");
		String registeredEmail = pr.getProperty("registeredEmail");
		String cssSelector = pr.getProperty("cssSelector");
		String signUpButton = pr.getProperty("signUpButton");
		String emailId = pr.getProperty("emailId");
		String userSignUpButton = pr.getProperty("userSignUpButton");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	     
		WebElement element = driver.findElement(By.cssSelector(".signupConfirmationPanel"));
		String message = element.getText();
		
		if(message.contains("Please check your inbox and click the link to activate your account.")) {
			driver.navigate().back();
			driver.findElement(By.xpath(signUpButton)).click();
			driver.findElement(By.xpath(emailId)).sendKeys(registeredEmail);
			driver.findElement(By.name(userSignUpButton)).click();
		}
		
		return new EmailPage(driver);
	}
}

