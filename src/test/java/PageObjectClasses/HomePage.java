package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
    WebDriver driver;
	public HomePage(WebDriver driver)
	{
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}	
	

	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	
	@FindBy (xpath="//a[@class='dropdown-item'][normalize-space()='Register']")
	
	WebElement Register;
	
    @FindBy (xpath="//a[normalize-space()='Login']")
	
	WebElement login;
	
	public void click_ON_myaccount()
	{
		myaccount.click();
	}
	

	public void click_ON_register()
	{
		Register.click();
	}
	
	public void click_ON_Login()
	{
		login.click();
	}
}
