package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadersPage {
	
	@FindBy (xpath="//a[@class='content selected tt']")
	private WebElement timeTrack ;
	
	@FindBy (xpath="//a[@class='content tasks']")
	private WebElement taskList ;
	
	@FindBy (xpath="//a[@class='content reports']")
	private WebElement reportDashBoard ;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement usersList ;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logOutButton ;
	
	public HeadersPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTimeTrack ()
	{
		timeTrack.click();
	}
	
	public void clickOnTaskList ()
	{
		taskList.click();
	}
	
	public void clickOnReportDashBoard () throws InterruptedException
	{
		Thread.sleep(4000);
		reportDashBoard.click();
	}
	
	public void clickOnUserList ()
	{
		usersList.click();
		
	}
	
	public void clickOnLogOutButton ()
	{
		logOutButton.click();
	}
	
	
	
	

}
