package com.php.genericLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib
{
public static HashMap<String, String> map = new HashMap();
	
	public void getWindowIDs(){
		Set<String> set = Base.driver.getWindowHandles();
         Iterator<String> it = set.iterator();
         String pID = it.next();
         String cID = it.next();
         map.put("parentID", pID);
         map.put("childID", cID);
	}
	
	
	public void select(WebElement selectelemnet ,String data){
		Select sel = new Select(selectelemnet);
		sel.selectByVisibleText(data);

	}
	
	public void alertOk(){
		Alert alt = Base.driver.switchTo().alert();
		alt.accept();
	}

	public void alertCancel(){
		Alert alt = Base.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void mouseMouse(WebElement elemnet){
		Actions act = new Actions(Base.driver);
		act.moveToElement(elemnet).perform();
	}
	
	public void rightClick(WebElement elemnet){
		Actions act = new Actions(Base.driver);
		act.contextClick(elemnet).perform();
	}
	
	public void waitForElemnet(WebElement element){
		WebDriverWait wait = new WebDriverWait(Base.driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElemnetMax(WebElement elemnet){
		int count =0;
		while(count<=20){
			try{
				elemnet.isDisplayed();
				break;
			}
			catch(Throwable t)
			{
				  try
				  {
					Thread.sleep(1000);
		          }
				  catch (InterruptedException e)
				  {
					  
				  }
			}
		}
		
	}

}
