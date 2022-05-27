package com.vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportContactPage {
	public ImportContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);			
	}
	
	@FindBy(id = "import_file") 
	private WebElement  importContactBtn;
	
	@FindBy(name = "next")
	private WebElement nextBtn;
	
	@FindBy(name = "import")
	private WebElement importBtn;
	
	@FindBy(name = "cancel")
	private WebElement finishBtn;
	
	public void sendFilePath(String path)
	{
		importContactBtn.sendKeys(path);
	}
	
	public void clickNext()
	{
		nextBtn.click();
	}
	
	public void clickImport()
	{
		importBtn.click();
	}
	
	public void clickFinish()
	{
		finishBtn.click();
	}
}
