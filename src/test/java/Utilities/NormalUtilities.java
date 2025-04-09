package Utilities;





import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.Base_TestCase;





public class NormalUtilities extends Base_TestCase
{
	

	public static String dynaicFirstname()
	{
		Random ram=new Random();
		String dynamic_firstname="aks"+ram.nextInt(1000);
		return dynamic_firstname;
	
	}
	
	
	public static String dynaicLastName()
	{
		Random ram=new Random();
		String dynamic_lastname="kam"+ram.nextInt(1000);
		return dynamic_lastname;
	
	} 
	 
	public static String dynaicpassword()
	{
		Date date=new Date();
		String dynamic_pass="aks_"+date.getTime();
		return dynamic_pass;
	}
   
	

	public static String dynaicEmail()
	{
		Date date=new Date();
		String dynamic_email="aks"+date.getTime()+"@gmail.com";
		return dynamic_email;
	}
	
	/*public static String randomfirstname_lastname_password()
	{
		String name = RandomStringUtils.randomAlphabetic(10);
		return name;
	}*/
	
	
	public String takeScreenShot( WebDriver driver) throws IOException
	{
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f1=ts.getScreenshotAs(OutputType.FILE);
		
		System.out.println("this is my f1:" +f1);
		//System.getProperty("user.dir")+"\\Screenshots\\abc.png"
		
		File f2=new File(loadPropertyFile().getProperty("screenshotpath"));
		FileUtils.copyFile(f1, f2);
		
		return f2.getAbsolutePath();
	}
	
	
	
}
