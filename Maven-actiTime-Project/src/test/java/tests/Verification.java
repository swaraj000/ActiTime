package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HeadersPage;
import pom.LoginPage;
import utils.Utility;

public class Verification  {
	
	public static void main(String[] args)  throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\AUTOMATION\\chrome version 103\\chromedriver.exe");
			 
    	 WebDriver driver = new ChromeDriver();
		 driver.get("https://online.actitime.com/skumar5/login.do");
		 
		//TestCase-1 --> to verify the url & title of login page
		//TestCase-2 --> to verify the by passing value in username textbox
		//TestCase-3 --> to verify the by passing value in password textbox
		//TestCase-4 --> to verify the login button
		 
		 
		 LoginPage loginPage = new LoginPage (driver);
		 
		 String userName = Utility.fetchDataFromExcel("Sheet1", 1, 0);
		 loginPage.sendUserName(userName);
		 
		 String password = Utility.fetchDataFromExcel("Sheet1", 1, 1);
		 loginPage.sendPassWord(password);
		 
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		
		 HeadersPage headers = new HeadersPage (driver);
		 
		//TestCase-1 --> to verify the url & title of task list page
		 headers.clickOnTaskList();
		 //String TestId ;
		 Utility.captureScreenshot(driver,"101");
		 
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
		 headers.clickOnLogOutButton();
		 
		 
         loginPage = new LoginPage (driver); 
		 
         userName = Utility.fetchDataFromExcel("Sheet1", 1, 0);
		 loginPage.sendUserName(userName);
		 
		 password = Utility.fetchDataFromExcel("Sheet1", 1, 1);
		 loginPage.sendPassWord(password);
		 
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		
		 headers = new HeadersPage (driver);
		 
		//TestCase-1 --> to verify the url & title of report page
		 headers.clickOnReportDashBoard();
		 url = driver.getCurrentUrl();
		 System.out.println(url);
		 title = driver.getTitle();
		 System.out.println(title);
		 
		 if(url.equals("https://online.actitime.com/skumar5/reports/dashboard.do") && title.equals("actiTIME - Reports Dashboard"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 headers.clickOnLogOutButton();
		 
		 
         loginPage = new LoginPage (driver); 
		 
          userName = Utility.fetchDataFromExcel("Sheet1", 1, 0);
		 loginPage.sendUserName(userName);
		 
		  password = Utility.fetchDataFromExcel("Sheet1", 1, 1);
		 loginPage.sendPassWord(password);
		 
		 loginPage.clickOnLoginButton();
		 Thread.sleep(2000);
		
		 headers = new HeadersPage (driver);
		 
		//TestCase-1 --> to verify the url & title of users list page
		 headers.clickOnUserList();
		 url = driver.getCurrentUrl();
		 System.out.println(url);
		 title = driver.getTitle();
		 System.out.println(title);
		 
		 if(url.equals("https://online.actitime.com/skumar5/administration/userlist.do") && title.equals("actiTIME - User List"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		 headers.clickOnLogOutButton();
		 
		 driver.quit();
		 
		 
	}

}
