package com.qa.toolsqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.toolsqa.base.BaseClassToolsqa;

public class HomePage extends BaseClassToolsqa{
	
	WebDriver mydriver;
	
	public HomePage(WebDriver driver)
	{
	  this.mydriver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath="//label[@id='userName-value' and text()='testone']")
	WebElement usernamedisplay;
	
	public String verifyusername()
	{
		return usernamedisplay.getText();
		
	}

	
	
	
}
