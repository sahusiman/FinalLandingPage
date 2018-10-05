package com.Lpage.app;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import objectRepo.LandingPageObjs;
import resources.LPageBase;

public class HomePageNavigation extends LPageBase {
   public static Logger log=LogManager.getLogger(HomePageNavigation.class.getName());
	@Test
	public void HomePageNavigatonTest() throws IOException, InterruptedException
	{
		
		driver=intializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		log.info("I am Opened");
		LandingPageObjs land= new LandingPageObjs(driver);
		land.getUserName().sendKeys("vfsvc-o365.spo-devadmin@vodafone-itc.com");
		land.Nextbtnclick().click();  
		Thread.sleep(1000);
		land.Password().sendKeys("itcadmin@1234");
		Thread.sleep(1000);
		land.signin().click();
	     
	}
	}



