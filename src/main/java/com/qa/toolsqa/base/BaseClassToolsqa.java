package com.qa.toolsqa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.toolsqa.utilits.Seleniumutils;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassToolsqa {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String screenshotpath;
	public static String propfilepath="./src/main/resources/config.properties";
	public static String extentfilepath="./Reports";
	

	/*public BaseClassToolsqa()
	
	{
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\Toolsqa\\src\\main\\resources\\config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {			
				e.printStackTrace();
			}catch (IOException e)
		
		 {
			e.printStackTrace();
		}
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Environment", "SIT");
	}*/
		
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		
		if (browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Pass the browser name correctly");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
	}
	

	@BeforeSuite
	public void extentreport()
	{
		prop = Propertyfile.propertyfileinit(propfilepath);
		
		extent=ExtentReportfile.extentreportconfig(extentfilepath);		
		/*htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);*/
		
	}
	@AfterSuite
	public void teardown()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException 
	{
		if (result.getStatus()==ITestResult.FAILURE) {
			test.fail(MarkupHelper.createLabel(result.getName()+"Test case Failed", ExtentColor.RED));
			screenshotpath=Seleniumutils.getscreenshot(driver, result.getName());
			//test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(Seleniumutils.getscreenBase64()).build());
			
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+"Test case Passed", ExtentColor.GREEN));
			screenshotpath=Seleniumutils.getscreenshot(driver, result.getName());
			//test.pass(result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
			test.pass(result.getName(),MediaEntityBuilder.createScreenCaptureFromBase64String(Seleniumutils.getscreenBase64()).build());
		}
		else {
			test.skip(MarkupHelper.createLabel(result.getName()+"Test case skipped", ExtentColor.BLACK));
			screenshotpath=Seleniumutils.getscreenshot(driver, result.getName());
			test.skip(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
	}
	
	
}


