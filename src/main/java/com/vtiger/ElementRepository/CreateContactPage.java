package com.vtiger.ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.WebDriverLibrary;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement organizationImage;
	
	@FindBy(name = "search_text")
	private WebElement searchTxt;
	
	@FindBy(name =  "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//tr[2]/td/a")
	private WebElement searchNameTxt;
	
	@FindBy(xpath = "//span[.='Creating New Contact']")
	private WebElement headerText;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTxt;
	
	public void createContact(String contactName)
	{
		lastNameTxt.sendKeys(contactName);
		SaveBtn.click();
	}
	
	public void createContactWithOrganization(String contactname, WebDriver driver, String path1, String organizationname, String path2) throws InterruptedException
	{
		lastNameTxt.sendKeys(contactname);
		organizationImage.click();
		WebDriverLibrary.switchToWindow(driver, path1);
		searchTxt.sendKeys(organizationname);
		searchBtn.click();
		driver.findElement(By.linkText(organizationname)).click();
		WebDriverLibrary.switchToWindow(driver, path2);
		SaveBtn.click();
	}
	
	public String getHeaderText()
	{
		return headerText.getText();
	}
	
	public String checkAlertPopup(WebDriver driver, String contactFirstName)
	{
		firstNameTxt.sendKeys(contactFirstName);
		SaveBtn.click();
		String data=WebDriverLibrary.getAlertText(driver);
		return data;
	}
}
