package Air_pagees;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import AIR_base.Air_baseclss;

public class Tofrom_page extends Air_baseclss{

		public    Tofrom_page(){

		PageFactory.initElements(wd, this);

		}
		
		
		public static void retcalender( String retmonth, String retdate) throws InterruptedException {
			
	

Thread.sleep(5000);					

					while(true) { //*[@id="flight-01-0"]/fieldset[2]/div[3]/div/section/div/table[2]/tbody/tr[2]/td[5]
						String date1= wd.findElement(By.xpath("//*[@id=\"flight-01-0\"]/fieldset[2]/div[3]/div/section/div/table[2]/caption")).getText();
						if(date1.equals(retmonth)) {
							break;
						}else 
						{
							wd.findElement(By.xpath("//*[@id=\"flight-01-0\"]/fieldset[2]/div[3]/div/section/nav/a[2]")).click();
						}
						
					} 
	                 String before_xpath= "//*[@id=\"flight-01-0\"]/fieldset[2]/div[3]/div/section/div/table[2]/tbody/tr[";
					String after_xpath="]/td[";

					final int totalweekday= 7;  /// total weeks

					boolean flag=false; /// to close outer loop

					String dayVal=null;
			
					for(int rowNum=1;rowNum<=7;rowNum++) {
						for(int colNum=1;colNum<=totalweekday;colNum++) {

						try {
							dayVal=wd.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).getText();}
						
						catch(NoSuchElementException e){
							System.out.println("please enter correct date");
							/// in some months 31 day is not available in that case it will display to enter correct date.
							
							flag= false;
							break;
							
						}
						System.out.println(dayVal);
						if(dayVal.equals(retdate)) {
							wd.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]")).click();
						flag=true;
						break;

						}

						
					}

					if(flag) {
						break;
					}
					
					}}}
					 

