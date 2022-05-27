package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.WebDriverLibrary;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "More")
	private WebElement moreTab;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
		
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//a[.='Contacts']")
	private WebElement contactLink;
	
	public WebElement returnMoreLinkAddress()
	{
		return moreTab;
	}
	
	public void clickContact()
	{
		
		contactLink.click();
	}
	
	public void clickCampain(WebDriver driver)
	{
		WebDriverLibrary.mouseHoverOnElement(driver, moreTab);
		campaignsLink.click();
	}
	
	public void clickProduct()
	{
		productLink.click();
	}
	
	public void clickDocument()
	{
		documentLink.click();
	}
	
	public void clickOrganiztion()
	{
		organizationLink.click();
	}
	
	public void logout(WebDriver driver)
	{
		WebDriverLibrary.mouseHoverOnElement(driver, adminIcon);
		signOutLink.click();
	}
	public WebElement getContactAdrees()
	{
		return contactLink;
	}
	
	public void mouseHoverAndClickContact(WebDriver driver)
	{
		WebDriverLibrary.mouseHoverOnElement(driver, contactLink);
		contactLink.click();
	}
}
