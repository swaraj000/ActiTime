package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class LoginPage {
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName ;
	
	@FindBy (xpath="(//input[@type='password'])[1]")
	private WebElement password ;

	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement loginButton ;
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName (String user) throws EncryptedDocumentException, IOException
	{
		userName.sendKeys(user);
		//String data = Utility.fetchDataFromExcel(0, 0);
		//userName.sendKeys("swarajpatel000@gmail.com");
	}
	public void sendPassWord (String pass) throws EncryptedDocumentException, IOException
	{
		//String data = Utility.fetchDataFromExcel(1,0);
		password.sendKeys(pass);
		//password.sendKeys("admin123");
	}
	
	public void clickOnLoginButton ()
	{
		loginButton.click();
	}

	
	
	
	
	

}
