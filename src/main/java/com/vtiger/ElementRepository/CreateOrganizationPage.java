package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.WebDriverLibrary;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationNameTxt;
	
	@FindBy(xpath ="//input[@accesskey='S']")
	private WebElement saveBtn;
	
	@FindBy(xpath ="//select[@name='industry']")
	private WebElement selectIndustryDropdown;
	
	@FindBy(xpath ="//select[@name='accounttype']")
	private WebElement selectTypeDropdown;
	
	public void createOrganization(String on)
	{
		organizationNameTxt.sendKeys(on);
		saveBtn.click();
	}
	
	public void createOrganizationWithIndustryAndType(String on, String inds, String type)
	{
		organizationNameTxt.sendKeys(on);
		WebDriverLibrary.dropdownSelectByValue(inds,selectIndustryDropdown);
		WebDriverLibrary.dropdownSelectByValue(type,selectTypeDropdown);
		saveBtn.click();
	}
}
