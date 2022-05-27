package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampainInformationPage {
	public CampainInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "dtlview_Campaign Name")
	private WebElement campaignNameTXT;
	
	public String campaignName()
	{
		return(campaignNameTXT.getText());
	}
	
	
}
