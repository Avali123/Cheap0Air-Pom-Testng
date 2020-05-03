package Air_TestCases;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import AIR_base.Air_Excelbase;
import Air_pagees.AIR_firstpage;
import Air_pagees.Tofrom_page;
import Air_pagees.fromtopage;
import Air_pagees.selection_page;

public class AIr_execute_sep  extends  Air_Excelbase{
		
		static AIR_firstpage  first;
		static selection_page selection;
		static fromtopage fromto;
		static Tofrom_page tofrom;
		
		public AIr_execute_sep() {
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
				
				
		@Test(priority=2)
		public void  fromtodetails() throws InterruptedException  {
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			int rowcount=reader.getRowCount("Sheet2");
			
			System.out.println("rowcount is :::"+rowcount);
			
            for(int rowNum=2; rowNum<=rowcount;rowNum++) {
            	
            
            	/// for from date
            	
            	String month=	reader.getCellData("Sheet2", "month", rowNum);
    			Thread.sleep(6000);

    			String day=	reader.getCellData("Sheet2", "day", rowNum);
    			Thread.sleep(6000);
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        System.out.println( month + "  "+ day);
    	
    	fromtopage.calender(month, day);
    	
            	// for to date
            	
    	String month1=	reader.getCellData("Sheet2", "	month1", rowNum);
		Thread.sleep(6000);

		String day1=	reader.getCellData("Sheet2", "day1", rowNum);
		Thread.sleep(6000);
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    System.out.println( month1 + "  "+ day1);

  Tofrom_page.retcalender(month1, day1);
		
	///////////// for toand from dest
		
    	
   	String from=	reader.getCellData("Sheet2", "from", rowNum);
			Thread.sleep(6000);
			String to=	reader.getCellData("Sheet2", "to", rowNum);
			Thread.sleep(6000);
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    System.out.println( from + "  "+ to);
	Thread.sleep(6000);

			first.fromtoodetails(from,to);
		
	/// for child detailssss
		
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String adult=	reader.getCellData("Sheet2", "	adult", rowNum);
			String senior=	reader.getCellData("Sheet2", "senior", rowNum);
			String minor=	reader.getCellData("Sheet2", "minor", rowNum);
			String coach=	reader.getCellData("Sheet2", "coach", rowNum);
			String child=	reader.getCellData("Sheet2", "child", rowNum);

			
	    System.out.println( adult + "  "+ senior+"  "+minor+" " +coach+" "+child);
			
			
		selection_page.	select(adult, senior, minor, coach);
		
	selection_page.child(child);
      
            
			Thread.sleep(4000);
			selection_page.search();
		String flightpagetiitle=	wd.getTitle();
		
		System.out.println("flightpage tittle :::::::::::"+flightpagetiitle);
		
		wd.navigate().back();
		}
		
		}
	
		
		
				@AfterClass
				public void tear() {
	             wd.close();
				}
		

	}





