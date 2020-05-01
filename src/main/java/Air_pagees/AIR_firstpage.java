package Air_pagees;

	

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import AIR_base.Air_baseclss;



public class AIR_firstpage extends Air_baseclss {


		@FindBy(xpath="//input[@id='from-01-0']")
		WebElement from;
		@FindBy(xpath="//input[@id='to-01-0']")
		WebElement to;
		@FindBy(xpath="//input[@id='departure-date-01-0']")
		WebElement deptdate;
		@FindBy(xpath="//input[@id='return-date-01-0']")
		WebElement retrndate;
		@FindBy(xpath="//span[contains(text(),'CheapOair.ca')]")
		WebElement text;
		
		@FindBy(id="departure-date-01-0")
		WebElement sec;
		
		@FindBy(id="return-date-01-0")
		WebElement ret;
	public    AIR_firstpage(){

	PageFactory.initElements(wd, this);

	}

	public String checktittle() {
		
	return	wd.getTitle();
	}
	public String  text(){
		
		return text.getText();
		
	}
	
	public void fromtoodetails( String des, String arravial) throws InterruptedException {
		
	from.sendKeys(des);
		Thread.sleep(3000);
		from.click();
		to.clear();
		Thread.sleep(2000);

to.sendKeys(arravial);
		Thread.sleep(3000);
		to.click();
	
	}
	
/// by js we can directly enter numberssss 
		public static  void datebyjs(WebElement element, WebDriver wd,String date){
	    	JavascriptExecutor js = ((JavascriptExecutor) wd);
	    	js.executeScript("arguments[0].setAttribute('value','"+date+"');", element);
	}


		
	

	public static void retdate(WebElement element, WebDriver wd,String retdate){
    	JavascriptExecutor js = ((JavascriptExecutor) wd);
    	js.executeScript("arguments[0].setAttribute('value','"+retdate+"');", element);
}
		
	
	

	}


