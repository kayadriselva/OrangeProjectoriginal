package com.qa.toolsqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.toolsqa.base.BaseClassToolsqa;
import com.qa.toolsqa.utilits.Seleniumutils;

public class Loginpage extends BaseClassToolsqa{
	
	//Loginpage//
	@FindBy(xpath="//button[@id='newUser']")
	WebElement newUserButton;

	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(id="userName")
	
	WebElement userName;
	
	@FindBy(id="password")
	WebElement pwd;
	
	//New user screen//
	
	@FindBy(id="firstname")
	WebElement firstName;

	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement reCaptchaclick;
	
	@FindBy(id="register")
	WebElement registerButton;
	

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String usernametxt, String passwordtxt)
	{
		Seleniumutils.entertext(userName, usernametxt);
		Seleniumutils.entertext(pwd, passwordtxt);
		Seleniumutils.eleclick(loginButton);	
	}
	
	
}
