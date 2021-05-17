package com.godaddy.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC_Godaddy_001 extends BaseClass {
	
	@Test
	public void OpenGodaddy() throws InterruptedException, IOException {
		logger.info("Window size has been set");
		Thread.sleep(1000);
		
		logger.info("Getting Title...");
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		Thread.sleep(1000);
		
		logger.info("Getting page URL...");
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Page URL: " + pageUrl);
		Thread.sleep(1000);
		
		logger.info("Getting Page Source Code...");
		String pageSourceCode = driver.getPageSource();
		System.out.println(pageSourceCode);
		Thread.sleep(5000);
		
		
		
	}

}
