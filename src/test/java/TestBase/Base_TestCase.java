package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Base_TestCase
{ 
	
	  public  WebDriver driver;
	  public Logger logger ;
	  public static Properties loadPropertyFile() throws IOException
	  {
		//loading properties file
          FileInputStream fis=new FileInputStream("./src/test/resources/config.properties");
          Properties prop=new Properties();
          prop.load(fis);
		  return prop;
	  }	  
	    //driver.get(loadPropertyFile().getProperty("url")); 
	  
	   @Parameters({"browser", "os"})
	   @BeforeMethod
	   public  void start(String browsername, String os) throws IOException
       {  
		   //loading log4j2.xml file 
		   
		  logger = LogManager.getLogger(this.getClass());
           //Execute test on remote system
           if(loadPropertyFile().getProperty("execution_evn").equalsIgnoreCase("remote"))
           {
        	   DesiredCapabilities cap=new DesiredCapabilities();
        	   //DECIDE BROWSER FOR REMOTE 
        	   switch(browsername.toLowerCase())
    		   {
    		   case "chrome": cap.setBrowserName("chrome"); break;
    		   case "firefox": cap.setBrowserName("firefox"); break;
    		   default : System.out.println("no matching browser");
    		  
    		   return; 
    		   }
        	   //DECIDE OPERATING SYSTEM FOR REMOTE
        	   if(os.equalsIgnoreCase("window"))
        	   {
        		   cap.setPlatform(Platform.WIN11);	  
        		   cap.setCapability("browserVersion", "125");
        	   }

        		//URL gridurl=new URL("http://10.46.35.112:4444/wd/hub");
        	   
        	    driver=new RemoteWebDriver(new URL("http://10.46.35.112:4444/wd/hub"),cap);
        	    driver.get(loadPropertyFile().getProperty("url")); 
           }
   
           else if(loadPropertyFile().getProperty("execution_evn").equalsIgnoreCase("local"))//Execute test on local system 
           {
		       switch(browsername.toLowerCase())
		       {
		       case "chrome": driver=new ChromeDriver(); break;
		        case "firefox": driver=new FirefoxDriver(); break;
		        default : System.out.println("no matching browser");
		         return; 
		        }
           }
		   
   /*      
           if(browsername.equalsIgnoreCase("chrome"))
           {
        	   driver=new ChromeDriver();
           }
           else if(browsername.equalsIgnoreCase("firefox"))
           {
        	   driver=new FirefoxDriver();
           }
   */        
		  
		   driver.get(loadPropertyFile().getProperty("url")); 
		   logger.info("navigated to url");
		
		  
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
       }
       
     
       @AfterMethod
       public void tearDown()
       {
    	   driver.close();
    	  
       }
       
      
}
