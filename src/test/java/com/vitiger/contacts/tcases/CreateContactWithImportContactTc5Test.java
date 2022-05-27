package com.vitiger.contacts.tcases;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.ImportContactPage;

public class CreateContactWithImportContactTc5Test extends BaseClass{
	@Test
	public  void createContactWithImportContactTc5Test() {
		String path = ExcelLibrary.getDataFromExcel("contact", 121, 1);
		ContactPage contactPage=new ContactPage(driver);
		ImportContactPage importContactPage=new ImportContactPage(driver);
		homepage.mouseHoverAndClickContact(driver);
		contactPage.clickImportContacts();
		importContactPage.sendFilePath(path);
		importContactPage.clickNext();
		importContactPage.clickImport();
		importContactPage.clickFinish();
	}
}
