package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	
	  WebDriver driver;
		public LoginPage(WebDriver driver)
		{
	       this.driver=driver;
	        PageFactory.initElements(driver, this);
		}	
		
		@FindBy (xpath="//input[@id='input-email']")
		WebElement usernameU;
		

		@FindBy (xpath="//input[@id='input-password']")
		WebElement passwordp;

		
		@FindBy (xpath="//input[@id='input-password']")
		WebElement login;
		
	
		public void enterUserName(String username)
		{
			usernameU.sendKeys(username);
			
		}
		

		public void enterPassword(String password)
		{
			passwordp.sendKeys(password);
		
		}
		
		public void clickLogin()
		{
			login.click();	
		}
		
}
