package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTxt;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	public void createProduct(String productName)
	{
		productNameTxt.sendKeys(productName);
		submitBtn.click();
	}
}
