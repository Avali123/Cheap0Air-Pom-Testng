package Air_TestCases;
	import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import AIR_base.Air_Excelbase;
import Air_pagees.AIR_firstpage;
import Air_pagees.Tofrom_page;
import Air_pagees.fromtopage;
import Air_pagees.selection_page;

public class Excelsheet_Air_Test  extends  Air_Excelbase{
		
		static AIR_firstpage  first;
		static selection_page selection;
		static fromtopage fromto;
		static Tofrom_page tofrom;
		
		public Excelsheet_Air_Test() {
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
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

				String tittle=	first.checktittle();
				System.out.println("Tittle is :::"+tittle);
				
				if(! reader.isSheetExist("home")) {
					reader.addSheet("home");
					}
	System.out.println("col count :::"+reader.getColumnCount("Sheet2"));
			
				}
				
				
		@Test(priority=5)
		public void  fromtodetails() throws InterruptedException  {
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			int rowcount=reader.getRowCount("Sheet2");
			
			System.out.println("rowcount is :::"+rowcount);
            for(int rowNum=2; rowNum<=rowcount;rowNum++) {
			String from=	reader.getCellData("Sheet2", "from", rowNum);
			String to=	reader.getCellData("Sheet2", "to", rowNum);
    System.out.println( from + "  "+ to);
			
			first.fromtoodetails(from,to);
			}
				}

			
		
		
	@Test(priority=3)
		public static void fromto() throws InterruptedException {
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				int rowcount=reader.getRowCount("Sheet2");
			
			System.out.println("rowcount is :::"+rowcount);
			
            for(int rowNum=2; rowNum<=rowcount;rowNum++) {
            	
			String month=	reader.getCellData("Sheet2", "month", rowNum);
			String day=	reader.getCellData("Sheet2", "day", rowNum);
    System.out.println( month + "  "+ day);
	
	fromtopage.calender(month, day);
			
		
			}
				}
			
		
	
	
	
		
		@Test(priority=4)
		public static void tofrom() throws InterruptedException {
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		int rowcount=reader.getRowCount("Sheet2");
		
		System.out.println("rowcount is :::"+rowcount);
		
        for(int rowNum=2; rowNum<=rowcount;rowNum++) {
     String month1=	reader.getCellData("Sheet2", "	month1", rowNum);
		String day1=	reader.getCellData("Sheet2", "day1", rowNum);
    System.out.println( month1 + "  "+ day1);

  Tofrom_page.retcalender(month1, day1);
		
	
		}
			
		}
		
		
		
		
		@Test(priority=7)
		public void text() {
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		System.out.println("Text of image is ::::  " +first.text() );
		}
		
		@Test(priority=6)
		public static void sec() throws InterruptedException {
			
			
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			int rowcount=reader.getRowCount("Sheet2");
			
			System.out.println("rowcount is :::"+rowcount);
	
           for(int rowNum=2; rowNum<=rowcount;rowNum++) {
	     String adult=	reader.getCellData("Sheet2", "	adult", rowNum);
			String senior=	reader.getCellData("Sheet2", "senior", rowNum);
			String minor=	reader.getCellData("Sheet2", "minor", rowNum);
			String coach=	reader.getCellData("Sheet2", "coach", rowNum);
			String child=	reader.getCellData("Sheet2", "child", rowNum);

			
	    System.out.println( adult + "  "+ senior+"  "+minor+" " +coach+" "+child);
			
			
		selection_page.	select(adult, senior, minor, coach);
		
	selection_page.child(child);
      }
		}
		
		@Test(priority=8)
		public static void main() throws InterruptedException {
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			Thread.sleep(4000);
			selection_page.search();
		String flightpagetiitle=	wd.getTitle();
		
		System.out.println("flightpage tittle :::::::::::"+flightpagetiitle);
	//	Assert.assertEquals( flightpagetiitle,"CheapOair - Save on Cheap Flights, Cheap Airfares, Cheap Tickets");
		}
		
	
		
		
				@AfterClass
				public void tear() {
					wd.getCurrentUrl();
				}
		

	}


