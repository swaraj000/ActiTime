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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browsers.Base;
import pom.HeadersPage;
import pom.HtmlTableOfPerformancePage;
import pom.LoginPage;
import pom.StaffPerformancePage;
import utils.Utility;

public class ReportDashBoardClassNG extends Base {
	
	WebDriver driver;
	HeadersPage headers;
	SoftAssert soft;
	LoginPage loginPage;
	String TestId ;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browserName")
	
	@BeforeTest 
	public void launchTheBrowser (String browser)
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
		 soft = new SoftAssert ();
	}
	
	@BeforeMethod
	public void logInTheApplication () throws InterruptedException, EncryptedDocumentException, IOException
	{
         driver.get("https://online.actitime.com/skumar5/login.do");
     
         String userName = Utility.fetchDataFromExcel("Sheet1", 1, 0);
		 loginPage.sendUserName(userName);
		 
		 String password = Utility.fetchDataFromExcel("Sheet1", 1, 1);
		 loginPage.sendPassWord(password);
		 
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000); 
	}
	
	@Test
	public void verifyUrlOfReport () throws InterruptedException
	{
		TestId="104";
		headers.clickOnReportDashBoard();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
	
		Assert .assertEquals(url, "https://online.actitime.com/skumar5/reports/dashboard.do");
		Assert.assertEquals(title, "actiTIME - Reports Dashboard");
		System.out.println("HELLO");
		
		
		
	}
	
	@Test (priority=1)
	public void clickONReportIcon ()  throws InterruptedException  
	{
		TestId="105";
		 headers.clickOnReportDashBoard();
		
		 String url = driver.getCurrentUrl();
		 System.out.println(url);
		 
		 soft.assertEquals(url, "https://online.actitime.com/skumar5/reports/dashboard.do");
		 Thread.sleep(5000);
		 
		 StaffPerformancePage staffPerformanceButton = new StaffPerformancePage (driver);
		 staffPerformanceButton.clickOnStaffPerformance();
		 
		 HtmlTableOfPerformancePage htmlTableData = new HtmlTableOfPerformancePage (driver);
		 htmlTableData.clickOnHtmlTableReport();
		 htmlTableData.generateTheTableValue();
		 
		 soft.assertAll();
	}
	
	@AfterMethod
	public void logOutFromApplication (ITestResult result) throws IOException
	{
		headers.clickOnLogOutButton();
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TestId);
		}
	}
	
	@AfterClass
	public void deleteObject ()
	{
		headers=null;
		loginPage=null;
		soft=null;
	}
	
	@AfterTest
	public void closeTheBrowser ()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	
	

}
