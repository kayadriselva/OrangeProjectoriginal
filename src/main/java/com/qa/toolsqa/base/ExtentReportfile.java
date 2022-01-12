package com.qa.toolsqa.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportfile {
	
	
	public static ExtentReports extentreportconfig(String extentfilepath)
	{
	//ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
	String date=new SimpleDateFormat("YYYYMMddhhmmss").format(new Date());
	ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(extentfilepath+"/ExtentReport"+date+".html");
	
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(htmlReporter);
	return extent;
}

	
	
	
}