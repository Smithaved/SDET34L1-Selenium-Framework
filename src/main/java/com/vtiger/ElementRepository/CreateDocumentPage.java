package com.vtiger.ElementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.genericUtility.WebDriverLibrary;

public class CreateDocumentPage {
	public CreateDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerTxt;
	
	@FindBy(name = "notes_title")
	private WebElement documentName;
	
	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement decriptionTxtArea;
	
	@FindBy(xpath = "//a[.='Bold']")
	private WebElement boldBtn;
	
	@FindBy(xpath = "//a[.='Italic']")
	private WebElement italicBtn;
	
	@FindBy(name = "filename")
	private WebElement fileInput;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public String getDocumentName()
	{
		return headerTxt.getText();
	}
	
	public void createDocumnet(String dn, WebDriver driver, String parag, String path) throws Throwable
	{
		documentName.sendKeys(dn);
		WebDriverLibrary.driverExplicitWait(10, driver);
		WebDriverLibrary.explicitWaitUntilSwitchToFrame(0);
		WebElement ele = decriptionTxtArea;
		ele.sendKeys(parag);
		ele.sendKeys(Keys.CONTROL+"a");
		WebDriverLibrary.switchBack(driver);
		WebDriverLibrary.explicitWaitUntilElementisClickable(boldBtn);
		boldBtn.click();
		italicBtn.click();
		fileInput.sendKeys(path);
		saveBtn.click();
	}
}
