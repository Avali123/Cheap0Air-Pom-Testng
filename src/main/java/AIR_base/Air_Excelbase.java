package AIR_base;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Air_UTIL.Air_Util;
import EXcelreader.Xls_Reader;



public class Air_Excelbase {
		
		
		public static WebDriver  wd;
		public static  Xls_Reader  reader;
		
		
		public  Air_Excelbase () {
			
		reader= new  Xls_Reader("C:\\Users\\jithe\\Desktop\\avali\\selenium test\\Cheap0Air-POM-Testng\\src\\main\\java\\Air_properties\\Excelsheeet.xlsx");
			
		}
		 public static  void initialization() {

		String	Browsername = reader.getCellData("Sheet2", 0, 2);
			
			

	if(Browsername.equals("chrome")) {
		

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\jithe\\Desktop\\avali\\chromedriver_win32\\chromedriver.exe" );
		 ChromeOptions options = new ChromeOptions();
		   options.addArguments("--disable-notifications");
		   /// give options instance in driver 
		 wd=new ChromeDriver(options);

	}

	// we can initisalze this load time outs in utilll class 
	wd.manage().deleteAllCookies();
	wd.manage().timeouts().implicitlyWait(Air_Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	wd.manage().timeouts().implicitlyWait(Air_Util.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);

	wd.manage().window().maximize();

String url=reader.getCellData("Sheet2", 1, 2);
			wd.get(url);
	}
	}











