package com.vtiger.ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.WebDriverLibrary;

public class CreateCampainPage {
	public CreateCampainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignNameTxt;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement productNameImage;
	
	@FindBy(name = "search_text")
	private WebElement searchTxt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//tr[2]/td/a")
	private WebElement productNameLink;
	
	public void createCampain(String campaignName)
	{
		campaignNameTxt.sendKeys(campaignName);
		submitBtn.click();
	}
	public void createCampainWithProduct(String campaignName, WebDriver driver, String title1, String productName, String title2) throws Throwable
	{
		campaignNameTxt.sendKeys(campaignName);
		productNameImage.click();
		WebDriverLibrary.switchToWindow(driver, title1);
		searchTxt.sendKeys(productName);
		searchBtn.click();
		driver.findElement(By.linkText(productName)).click();
		WebDriverLibrary.switchToWindow(driver, title2);
		submitBtn.click();
	}
}
