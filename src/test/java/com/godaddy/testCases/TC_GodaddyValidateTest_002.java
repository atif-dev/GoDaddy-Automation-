//Test case description: Open Godaddy.com and Validate Page Title + PageURL + Page title in Source code
package com.godaddy.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.godaddy.pageObjects.GodaddyValidate;

public class TC_GodaddyValidateTest_002 extends BaseClass {
	
	@Test
	public void GodaddyValidateTest() throws InterruptedException, IOException {
		
		  Thread.sleep(2000); 
		  logger.info("Window size has been set");
		  Thread.sleep(3000);
		 
		
		
		  logger.info("Validating page title, URL and Source Code Title..."); 
		  String expected_title = driver.getTitle(); 
		  String actual_title = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy PK";
		  
		  String expected_pageUrl = driver.getCurrentUrl();
		  String actual_url = "https://pk.godaddy.com/"; //https://pk.godaddy.com == https://pk.godaddy.com/ in browser
		  
		  String sourceCode = driver.getPageSource();
		  String srcCodeSubString = sourceCode.substring(246, 319);
		  String titleFirstPrt = srcCodeSubString.substring(0,33);
		  String titleSecondPrt = srcCodeSubString.substring(37);
		  String sourceCodeTitle = titleFirstPrt + titleSecondPrt;
		  
		  int count = 0;
		  int expectedCount = 3;
		  if(expected_title.contains(actual_title)) {
			  logger.info("Title matched with actual title");
			  count++;
			  if(expected_pageUrl.contains(actual_url)) {
				  logger.info("URL macthed with actual URL");
				  count++;
			  }else {
				  logger.info("URL doesn't macth");
				  Assert.assertTrue(false);
			  }
			  if(sourceCodeTitle.equals(actual_title)) {
				  
				  logger.info("Actual title match with Source Code title");
				  count++;
			  }else {
				  
				  logger.info("Actual title doesn't match with Source Code title");
				 Assert.assertTrue(false);
				 
			  }
		  }else {
			  logger.info("Title doesn't matche with actual title");
			  Assert.assertTrue(false);
		  }
		  
		  ///Check for title + URL + Source code title
		  if(count == expectedCount) {
			  logger.info("Test case passed");
			  Assert.assertTrue(true);
		  }
		 
		  
		 


//		String pageSourceCode = driver.getPageSource();
		
		/*
		 * if(pageSourceCode.contains(actual_title)) { System.out.println("True"); }
		 */
		
		
		
		
		
	}

}
