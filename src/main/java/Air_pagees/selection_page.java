package Air_pagees;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AIR_base.Air_Excelbase;

public class selection_page  extends  Air_Excelbase{


public    selection_page(){

PageFactory.initElements(wd, this);

}

	


public  static Flight_page  search() throws InterruptedException {
	Thread.sleep(3000);
WebElement search=	 wd.findElement(By.xpath("//*[@id=\"search-btn\"]"));
	search.click();
	return new Flight_page();
}

	public static void select(String ad,String se, String mi, String co) { 
		
		
	Select adult= new Select(wd.findElement(By.id("adult-travelers")));
	 Select senior= new Select(wd.findElement(By.id("senior-travelers")));
Select minor= new Select(wd.findElement(By.id("minor-travelers")));
		Select coach= new Select(wd.findElement(By.id("ddClass")));
		
		
	adult.selectByVisibleText(ad);
	senior.selectByVisibleText(se);
	minor.selectByVisibleText(mi);
	coach.selectByVisibleText(co);
	
}
	





	public static void child(String ch) {
		Select child= new Select(wd.findElement(By.id("children-0-selector-01")));
child.selectByVisibleText(ch);
	}




		
	}
	
	



	



