package com.qa.toolsqa.TestCases;

import java.io.IOException;

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
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class HomePageTest extends BaseClassToolsqa {

	Loginpage login;
	HomePage home;

	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login=new Loginpage();
		home= new HomePage(driver);
		login.login(prop.getProperty("username"), prop.getProperty("pwd"));
		
	}
	
	
	@Test
	public void verifyusername() 
	{
		
		test=extent.createTest("verifyusername");
		
	String usernameinhomepage = home.verifyusername();
	
	Assert.assertEquals("testonre", usernameinhomepage);
	
	}
	
	

}