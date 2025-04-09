package TestCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClasses.HomePage;
import PageObjectClasses.LoginPage;

import TestBase.Base_TestCase;


public class TestCase_Login extends Base_TestCase
{
	String firstname;
	String password;
	HomePage hp ;

	

	@Test(priority=2)
	void login() throws InterruptedException, IOException {
		HomePage hp=new HomePage(driver);
		hp.click_ON_myaccount();
	    logger.info("my account clicked");
		
		
		Thread.sleep(3000);
		hp.click_ON_Login();
		  logger.info(" login link clicked");

		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(TestCase_Register.returnEmail1());
		  logger.info("username entered");
		
		
		lp.enterPassword(TestCase_Register.returnpassword1());
		  logger.info("password entered");
		
		lp.clickLogin();
		  logger.info("login button clicked");
		
		Assert.assertTrue(true);
		
	}

}
