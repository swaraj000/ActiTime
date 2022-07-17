package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	
	public static WebDriver openChromeBrowser ()
	{
		 //System.setProperty("webdriver.chrome.driver","D:\\AUTOMATION\\chrome version 103\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Browserfile\\chromedriver.exe");
  	     WebDriver driver = new ChromeDriver ();
  	     return driver;
	}
	
	public static WebDriver openFirefoxBrowser ()
	{
		// System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\firefox\\geckodriver.exe");
		 System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Browserfile\\geckodriver.exe");
  	     WebDriver driver = new FirefoxDriver ();
  	     return driver;
	}
	
	public static WebDriver openOperaBrowser ()
	{
		 System.setProperty("webdriver.opera.driver","src\\test\\resources\\Browserfile\\operadriver.exe");
  	     WebDriver driver = new OperaDriver ();
  	     return driver;
	}
	
	public static WebDriver openEdgeBrowser ()
	{
		 System.setProperty("webdriver.edge.driver","src\\test\\resources\\Browserfile\\msedgedriver.exe");
  	     WebDriver driver = new EdgeDriver ();
  	     return driver;
	}

}
