package com.php.genericLib;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.genericlib.FileLib;
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
	 @AfterSuite
	   public void configAs() {
		   report.flush();
		   report.close();
	   }
	    /**
	     * Description: it describes the launching of the browser
	     * @throws Throwable
	     */
	     @BeforeClass(groups= {"smoketest"})
	     public void config() throws Throwable {
	    	 System.out.println("=====launch browser========");
	    	 Properties properties=com.php.genericLib.FileLib.getPropertiesObj();
	    	 driver=new FirefoxDriver();
	    	 //if(pObj.getProperty("browser").equals("firefox")) {
	    		//System.setProperty("webdriver.gecko.driver","D:\\Automationsw\\thirdpartydrivers\\geckodriver.exe" );
	    
	    		 //driver=new FirefoxDriver();
	    		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	 //}
	    	 
	     }
	    	 
	     /**
	      * Description: it describes the login 
	      * @throws Throwable
	      */
	    	 @BeforeMethod(groups= {"smoketest"})
	    	 public void configBM() throws Throwable
	    	 {
	    		 System.out.println("login");
	    		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    		 FileLib file = new FileLib();
	    		 Properties properties=file.getPropertiesObj();
	    		 driver.get(properties.getProperty("url"));
	    		 //driver.get("localhost:8888/");
	    		 driver.findElement(By.name("user_name")).sendKeys(properties.getProperty("username"));
	             driver.findElement(By.name("user_password")).sendKeys(properties.getProperty("password"));
	             driver.findElement(By.id("submitButton")).click();
	    	 }
	    	 /**
	    	  * Description: it describes the logout 
	    	  */
	         @AfterMethod(groups= {"smoketest"})
	         public void configAM()
	         {
	        	 
	        	
	        	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        WebElement wb  =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        	
	           
	   
					// TODO: handle exception
	            	Actions act = new Actions(driver);	
	                act.moveToElement(wb).perform();
	                	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
	         }
	         
	        	@AfterClass(groups= {"smoketest"})
	        		public void configAc() {
	        		driver.close();
	        		
	        	}
	        	

	
}
