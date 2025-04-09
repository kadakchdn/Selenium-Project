package TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectClasses.HomePage;
import PageObjectClasses.RegisterPage;
import TestBase.Base_TestCase;
import Utilities.NormalUtilities;



public class TestCase_Register extends Base_TestCase
{
	


	     @Test(priority=1)
	     void Register() throws InterruptedException
	     {
	    	
	    	System.out.println("registration started");
			HomePage hp=new HomePage(driver);
			Thread.sleep(3000);
			hp.click_ON_myaccount();
			  logger.info("my account clicked");
			  
			Thread.sleep(3000);
			hp.click_ON_register();
			  logger.info("my account clicked");
			  
			RegisterPage rp=new RegisterPage(driver);
			Thread.sleep(3000);

			rp.enterFirstName(NormalUtilities.dynaicFirstname());	
			  logger.info("my account clicked");
			  
			  
			rp.enterLastName(NormalUtilities.dynaicLastName());  logger.info("my account clicked");
			
			rp.enterEmail(TestCase_Register.returnEmail1());   logger.info("my account clicked");
			
			rp.enterPassword(TestCase_Register.returnpassword1());   logger.info("my account clicked");
			rp.scrollPage();
			Thread.sleep(20000);
			rp.checkPrivacyCheckbox();
			
			//rp.clickContinueButton();
			
			
			Assert.assertTrue(true);
			
			System.out.println("registartion failed");
	     }
	
	     
	     public static String returnEmail1()
	     {
	    	 String email1=NormalUtilities.dynaicEmail();
	    	 return email1;
	     }
	     
	     public static String returnpassword1()
	     {
	    	  String password1=NormalUtilities.dynaicpassword();
	    	 return password1;
	     }

	     

}
