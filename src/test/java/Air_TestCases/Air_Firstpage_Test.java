package Air_TestCases;

	

	import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import AIR_base.Air_baseclss;
import Air_pagees.AIR_firstpage;
import Air_pagees.Tofrom_page;
import Air_pagees.fromtopage;
import Air_pagees.selection_page;




	public class Air_Firstpage_Test  extends Air_baseclss{
		
		static AIR_firstpage  first;
		static selection_page selection;
		static fromtopage fromto;
		static Tofrom_page tofrom;
		public Air_Firstpage_Test () {
					super();
				}
				
				@BeforeClass
				public static void setup() {
					initialization();
					first= new AIR_firstpage();
					selection= new selection_page();
					fromto= new fromtopage();
					tofrom= new Tofrom_page();
						}
				
				
				@Test(priority=1)
				public void enter() {
				String tittle=	first.checktittle();
				System.out.println("Tittle is :::"+tittle);
				}
				
				
		@Test(priority=5)
		public void  fromtodetails() throws InterruptedException  {
			first.fromtoodetails(p.getProperty("from"), p.getProperty("to"));
			
		}
		
		
	/*	@Test(enabled=true)
		public static void dates() {
			WebElement sec=	wd.findElement(By.id("departure-date-01-0"));
			
			
			AIR_firstpage.datebyjs(sec, wd, p.getProperty("date"));
			WebElement ret =wd.findElement(By.	id("return-date-01-0"));
			AIR_firstpage.retdate(ret, wd, p.getProperty("retdate"));
			
		}*/
		
		@Test(priority=3)
		public static void fromto() throws InterruptedException {
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			fromtopage.calender(p.getProperty("month"), p.getProperty("day"));
			
		}
		
		@Test(priority=4)
		public static void tofrom() throws InterruptedException {
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			Tofrom_page.retcalender(p.getProperty("month1"), p.getProperty("day1"));
		}
		
		
		
		
		@Test(priority=7)
		public void text() {
	
		System.out.println("Text of image is ::::  " +first.text() );
		}
		
		@Test(priority=6)
		public static void sec() throws InterruptedException {
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		selection_page.	select(p.getProperty("adult"), p.getProperty("senior"), p.getProperty("minor"), p.getProperty("coach"));
		
	selection_page.child(p.getProperty("child"));
		}
		
		@Test(priority=8)
		public static void main() throws InterruptedException {
			Thread.sleep(4000);
			selection_page.search();
		String flightpagetiitle=	wd.getTitle();
		
		System.out.println("flightpage tittle :::::::::::"+flightpagetiitle);
		Assert.assertEquals( flightpagetiitle,"CheapOair - Save on Cheap Flights, Cheap Airfares, Cheap Tickets");
		}
		
	
		
		
				@AfterClass
				public void tear() {
					wd.quit();
				}
		

	}



