package PageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	JavascriptExecutor js;
	
	public RegisterPage(WebDriver driver)
	{
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}	
	
	
	
	@FindBy (xpath="//input[@id='input-firstname']")
	
	WebElement firstnamefield;
	
	
	@FindBy (xpath="//input[@id='input-lastname']")
	
	WebElement lastnamefield;
	
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement emailfield;
	
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement passwordfield;
	
	
	@FindBy (xpath="//input[@name='agree']")
	WebElement privacycheckbox;
	
	
	@FindBy (xpath="//button[normalize-space()='Continue']")
	WebElement continueButton;
	
	@FindBy (xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement message;
	
	
	public  void enterFirstName(String firstname)
	{
		firstnamefield.sendKeys(firstname);
		
		
	}
	

	public void enterLastName(String Lastname )
	{
		lastnamefield.sendKeys(Lastname);
	}

	public void enterEmail(String email)
	{
		emailfield.sendKeys(email);
	}
	

	public void enterPassword(String password)
	{
		passwordfield.sendKeys(password);
		
	}
	
	public void checkPrivacyCheckbox()
	{
		//privacycheckbox.click();
		js.executeScript("arguments[0].click();", privacycheckbox);
		
	}
	
	public void clickContinueButton()
	{
		//continueButton.click();
		js.executeScript("arguments[0].click();", continueButton);
	}
	
	public void scrollPage()
	{
		js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", privacycheckbox);
	}
	
	public void successmessage()
	{
		System.out.println(message.isDisplayed());
		
	}
	public void clickLogout()
	{
		logout.click();
		
	}
	
}
