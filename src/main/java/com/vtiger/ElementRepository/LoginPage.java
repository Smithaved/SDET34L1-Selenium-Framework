package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name = "user_name")
	private WebElement userNameTxt;
	
	@FindBy(name = "user_password")
	private WebElement userPasswordTxt;
	
	@FindBy(id = "submitButton")
	private WebElement LoginBTN;

	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void  loginAction(String username, String password)
	{
		userNameTxt.sendKeys(username);
		userPasswordTxt.sendKeys(password);
		LoginBTN.click();
	}
}
