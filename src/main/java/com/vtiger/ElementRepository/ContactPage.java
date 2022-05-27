package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;



public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactImage;
	
	@FindBy(xpath = "//img[@alt='Last Viewed']")
	private WebElement lastViewImage;
	
	@FindBy(xpath = "//img[@alt='Import Contacts']")
	private WebElement importContacts;
	
	@FindBy(name = "search_text")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']//select[@name='search_field']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']/../..//td[@class='small']/input[@value=' Search Now ']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@name='selected_id']")
	private WebElement contactCheckbox;
	
	@FindBy(xpath = "//table[@class='small']//input[@value='Delete']")
	private WebElement deleteBtn;
	
	public void clickCreateContact()
	{
		JavaLibrary.customWait(createContactImage, 2, 10);
		//createContactImage.click();
	}
	
	
	public void clickViewContact()
	{
		lastViewImage.click();
	}
	
	public void clickImportContacts()
	{
		importContacts.click();
	}
	
	public void searchContact(String searchName, String searchFilter) {
		searchTxt.sendKeys(searchName);
		WebDriverLibrary.dropdownSelectByValue(searchFilter, searchDropdown);
		searchBtn.click();
	}
	
	public void deletContact(WebDriver driver) throws InterruptedException
	{
		JavaLibrary.customWait(contactCheckbox, 2, 10);
		contactCheckbox.click();
		deleteBtn.click();
	}
}
