package com.qa.toolsqa.utilits;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.toolsqa.base.BaseClassToolsqa;

public class Seleniumutils extends BaseClassToolsqa{
	
	
	public static void waitvisibleele(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitclickele(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void entertext(WebElement ele, String text)
	{
		waitvisibleele(ele);
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static void eleclick(WebElement ele)
	{
		waitclickele(ele);
		ele.click();
	}
	
	public static void scrolltoele(WebElement ele)
	{
		waitvisibleele(ele);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView(true)", ele);
	}
	
	public static void dropdown(WebElement ele, int index)
	{
		waitvisibleele(ele);
		Select s= new Select(ele);
		s.selectByIndex(index);
	}

	public static String getscreenshot(WebDriver driver, String screenshotname) throws IOException 
	{
		TakesScreenshot tk= (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/Failedtestscreenshot/"+screenshotname+".png";
		File desc= new File(destination);
		FileUtils.copyFile(src, desc);
		return destination;
	}

	
	public static String getscreenBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}

	public static void logpass(String desc) throws IOException {
		//test.log(Status.PASS, desc+test.addScreenCaptureFromPath(getscreenshot()));
		test.pass(desc,MediaEntityBuilder.createScreenCaptureFromBase64String(getscreenBase64()).build());
	}
	
	public static void logfail(String desc) throws IOException  {
		//test.log(Status.FAIL, desc+test.addScreenCaptureFromPath(getscreenshot()));
		test.fail(desc,MediaEntityBuilder.createScreenCaptureFromBase64String(getscreenBase64()).build());
	}

	

	
	
}
