package TestCases;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjectClasses.HomePage;
import PageObjectClasses.RegisterPage;
import TestBase.Base_TestCase;




public class TestCase_Register_DDT extends Base_TestCase
{
	


	     @Test(priority=1, dataProvider="getData")
	     void Register(String fn, String ln, String em, String pw) throws InterruptedException
	     {
	    	
			HomePage hp=new HomePage(driver);
			Thread.sleep(3000);
			hp.click_ON_myaccount();
			  logger.info("my account clicked");
			  
			Thread.sleep(3000);
			hp.click_ON_register();
			  logger.info("my account clicked");
			  
			RegisterPage rp=new RegisterPage(driver);
			Thread.sleep(3000);

			rp.enterFirstName(fn);	
			  logger.info("my account clicked");
			  
			  
			rp.enterLastName(ln);  logger.info("my account clicked");
			
			rp.enterEmail(em);   logger.info("my account clicked");
			
			rp.enterPassword(pw);   logger.info("my account clicked");
			rp.scrollPage();
			Thread.sleep(20000);
			rp.checkPrivacyCheckbox();
			
			//rp.clickContinueButton();
			
			
			Assert.assertTrue(true);

	     }
	     
	
	     @DataProvider
	     public String[][] getData()
	     {
	    	 
	    	 String data[][]= {
	    			 
	    			 {"firstname1","lastname1","email1@gmail.com","password1"},
	    			 {"firstname2","lastname2","email2@gmail.com","password2"},
	    			 {"firstname3","lastname3","email3@gmail.com","password3"},
	    			 {"firstname4","lastname4","email4@gmail.com","password4"},	 
	    			 
	    	 };
	    	 return data;
	     }

	     

}
