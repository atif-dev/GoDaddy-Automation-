package com.godaddy.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.testng.log4testng.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.godaddy.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();//readconfig is an object,,,,new ReadConfig(); is invoking default constructor of ReadConfig.java	
	public String baseURL = readconfig.getApplicationURL();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("godaddy");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		
		  System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		  driver = new ChromeDriver();
			
		 
		}else if(br.equals("firefox")) { 
			System.setProperty("webdriver.gecko.driver",
		  readconfig.getFirefoxPath()); driver = new FirefoxDriver(); 
		  
		}
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		//driver.manage().window().maximize();
		logger.info("URL is Opened");
	
		Dimension d = new Dimension(1477,729);
		//Dimension d = new Dimension(1477,830);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);
       
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	

	
}
