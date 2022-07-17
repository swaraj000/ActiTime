package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browsers.Base;
import pom.HeadersPage;
import pom.LoginPage;
import utils.Utility;

public class TestClassNG extends Base {
	
	WebDriver driver;
	LoginPage loginPage;
	HeadersPage headers;
	String TestId ;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browserName")
	
	@BeforeTest
	public void launchBrowser (String browser)
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if (browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("Opera"))
		{
			driver = openOperaBrowser();
		}
		if (browser.equals("Edge"))
		{
			driver = openEdgeBrowser();		
		}

	}
	
	@BeforeClass
	public void createObject ()
	{
		loginPage = new LoginPage (driver);
		headers = new HeadersPage (driver);
	}
	
	
	@BeforeMethod
	public void testLoginPage () throws InterruptedException, EncryptedDocumentException, IOException
	{
		 driver.get("https://online.actitime.com/skumar5/login.do");
		 
		 String userName = Utility.fetchDataFromExcel("Sheet1", 1, 0);
		 loginPage.sendUserName(userName);
		 
		 String password = Utility.fetchDataFromExcel("Sheet1", 1, 1);
		 loginPage.sendPassWord(password);
		 
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
	}
	
	@Test (priority=0)
	public void testTaskList () throws IOException
	{
		TestId ="101";
         headers.clickOnTaskList();
		 
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 if(url.equals("https://online.actitime.com/skumar5/tasks/tasklist.do") && title.equals("actiTIME - Task List"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		//Assert.assertEquals(url, "https://online.actitime.com/skumar5/tasks/tasklist.do");
	}
	
	@Test (priority =1)
	public void testReportDashBoard () throws InterruptedException
	{
		TestId ="102";
		 headers.clickOnReportDashBoard();
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		 if(url.equals("https://online.actitime.com/skumar5/reports/dashboard.do") && title.equals("actiTIME - Reports Dashboard"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		//Assert.assertNotEquals(url, "https://online.actitime.com/skumar5/reports/dashboard.d", "Validadte URL");
	}
	
	@Test
	public void testUserList ()
	{
		TestId ="103";
		 headers.clickOnUserList();
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 String title = driver.getTitle();
		 System.out.println(title);
		 
		boolean resultURL =  url.equals("https://online.actitime.com/skumar5/administration/userlist.do");
		boolean resultTitle = title.equals("actiTIME - User List");
		 
		 if(url.equals("https://online.actitime.com/skumar5/administration/userlist.do") && title.equals("actiTIME - User List"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		
		//Assert.assertTrue(resultURL);
		//Assert.assertFalse(resultTitle);
		 System.out.println("HELLO");
	}
	
	@AfterMethod
	public void logOutApplication (ITestResult result) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		 headers.clickOnLogOutButton();
		 
		 if (ITestResult.FAILURE==result.getStatus())
		 {
			 Utility.captureScreenshot(driver,TestId);
		 }
	}
	
	@AfterClass
	public void deleteObject()
	{
		loginPage=null;
		headers=null;
	}
	
	
	@AfterTest
	public void closeApplication ()
	{
		driver.quit();
		driver =null;
		System.gc();  // garbage collector
	}
    
	
	
	
	
	
	

}
