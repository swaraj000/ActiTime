package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HtmlTableOfPerformancePage {
	
	@FindBy (xpath="//span[@id='applyReportConfiguration']")
	private WebElement htmlTableReport ;
	
	private WebDriver driver ;
	static int j;
	public HtmlTableOfPerformancePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOnHtmlTableReport () throws InterruptedException
	{
		htmlTableReport.click();
		Thread.sleep(2000);
	}
	
	public void generateTheTableValue ()
	{
		 for (int i =1; i<=6; i++)
		 {
			 for ( j=0; j<=5; j++)
			 {
				 List <WebElement> reportTableValue = driver.findElements(By.xpath("//table[@id='report-table']//tr["+i+"]//td"));
				 String value = reportTableValue.get(j).getText();
			     System.out.print(value);
			     
			     if(j<5)
			     {
			    	 System.out.print(",");
			     }
			     else
			     {
			    	 System.out.println();
			     }
			}
			 System.out.println("Row= "+i+ "&" + "Cell= "+j);
		 }
	}
	

}
