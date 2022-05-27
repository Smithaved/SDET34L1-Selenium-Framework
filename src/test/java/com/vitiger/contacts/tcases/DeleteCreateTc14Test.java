package com.vitiger.contacts.tcases;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.vtiger.ElementRepository.ContactPage;

public class DeleteCreateTc14Test extends BaseClass{
	@Test
	public  void deleteCreateTc14Test() throws InterruptedException {
		
		String contactName = ExcelLibrary.getDataFromExcel("contact", 156, 1);
		String searchFilter = ExcelLibrary.getDataFromExcel("contact", 156, 2);
		ContactPage contactPage=new ContactPage(driver);
		homepage.clickContact();
		contactPage.searchContact(contactName, searchFilter);
		contactPage.deletContact(driver);
		WebDriverLibrary.alertAccept(driver);
	}

}
