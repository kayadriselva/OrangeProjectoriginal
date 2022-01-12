package com.qa.toolsqa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.toolsqa.base.BaseClassToolsqa;
import com.qa.toolsqa.pages.HomePage;
import com.qa.toolsqa.pages.Loginpage;
import com.qa.toolsqa.utilits.Seleniumutils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends BaseClassToolsqa {
	
	Loginpage login;
	HomePage homepage;
	

	@BeforeMethod
	public void setup()
	{
		initialization();
		login= new Loginpage();
		homepage= new HomePage(driver);
		
	}
	
	
	@Test
	public void loginTest()
	{
		test=extent.createTest("LoginTest");
		 login.login(prop.getProperty("username"), prop.getProperty("pwd"));
		 Assert.assertTrue(false);
	}
	
	@Test
	public void checkfail()
	{
		test=extent.createTest("checkfail");
		 
		 Assert.assertTrue(true);
	}
	
	
		
	}
