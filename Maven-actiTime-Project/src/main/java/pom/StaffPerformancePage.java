package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffPerformancePage {
	
	@FindBy (xpath="(//div[@class='components-NewReportPanel-listItem--rmPqeADl'])[1]")
	private WebElement staffPerformance ; 
	
	private Actions act;
	
	public StaffPerformancePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 act = new Actions (driver);
	}
	
	public void clickOnStaffPerformance () throws InterruptedException
	{
		 act.moveToElement(staffPerformance).click().build().perform();
		Thread.sleep(2000);
	}

}
