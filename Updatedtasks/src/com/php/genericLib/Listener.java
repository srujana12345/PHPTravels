package com.php.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{
	public void onTestFailure(ITestResult r) {
		
		  String faildTestNAme = r.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Base.driver);
		
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
	
		File dstFile = new File(".\\screenShot\\"+faildTestNAme+".png");
		try {
			FileUtils.copyFile(srcfile, dstFile);
		                             
		} 
		catch (IOException e) {}
		
	}
	 
{

}

@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

@Override
public void onFinish(ITestContext context)
{
	// TODO Auto-generated method stub
	
}
}
