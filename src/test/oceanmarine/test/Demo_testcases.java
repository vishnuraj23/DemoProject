package test;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import BaseTest.BaseTest;



public class Demo_testcases extends BaseTest {
	
	String path = Path+ prop.getProperty("testsheetpath");
	String name = prop.getProperty("testsheetname");
	String Sheetname= "LogIn";
	
	@Parameters({ "Browser" , "URL" })
	@Test(priority = 1, enabled = true)
	public static void LaunchBrowser(String browser, String URL) throws Exception {

		Browser(browser, URL);
	}
	
//	@Test(priority = 2, enabled = true)
//	public static void LoginPage(String Browser) throws Exception {
//
//		
//	}
	
//	@DataProvider
//	public Object[][] LoginDetails() throws Exception {
//			Object data[][]= ExcelUtility.getExcelData(path, name, Sheetname);
//			return data;
//					
//			
//	}
}
