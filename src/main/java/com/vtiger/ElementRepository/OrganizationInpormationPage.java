package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInpormationPage {
	public OrganizationInpormationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement organizationNameTxt;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerTextTxt;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryValuedd;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeValuedd;
	
	public String getOrganizationName()
	{
		return organizationNameTxt.getText();
	}
	public WebElement getAddresOfOrganizationName()
	{
		return organizationNameTxt;
	}
	public String getHeaderText()
	{
		return headerTextTxt.getText();
	}
	
	public String getIndustry()
	{
		return industryValuedd.getText();
	}
	
	public String getType()
	{
		return typeValuedd.getText();
	}
}
