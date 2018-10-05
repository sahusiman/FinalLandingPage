package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LPageBase {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException
	{
	   //Setting Properties File
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vodafone\\LandingPage\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		prop.getProperty("browser");
		String browserName =prop.getProperty("browser");
		//Setting Browser values
		if(browserName.equals("IE"))
		{  
			File IEDriver = new File("C:\\bin\\IEDriverServer.exe");
			  System.setProperty("webdriver.ie.driver", IEDriver.getAbsolutePath() );  
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			  System.setProperty("webdriver.ie.driver","C:\\bin\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver(capabilities);
		    }  
		else if(browserName.equals("Firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\bin\\geckodriver.exe");
		     FirefoxOptions options = new FirefoxOptions();
		     options.setCapability("marionette", false);
		     driver=new FirefoxDriver(options);
		     driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C://Test//"+result+"screenshot.png"));
        
	}

}


