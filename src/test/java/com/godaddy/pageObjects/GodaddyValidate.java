
package com.godaddy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GodaddyValidate {

	WebDriver ldriver;
	public GodaddyValidate(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html")
	@CacheLookup
	WebElement htmlString;
	
	public String getSourceCode() {
		String srcCode = htmlString.getText();
		return srcCode;

	}
	
	
}
