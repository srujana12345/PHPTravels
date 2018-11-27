package com.php.genericLib;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;

public class Base 
{
	public static WebDriver driver;
	public ExtentReports report;
	
	@BeforeSuite
	public void configBeforeSuite()
	{
		 String currentDate = new Date().toString().replace(" ", "_").replace(":",  "_");
		   report = new ExtentReports  ("./advanceReport/"+currentDate +"_extent.html");
		   report.loadConfig(new File("./extent-config.xml"));
	}
	
	
}
