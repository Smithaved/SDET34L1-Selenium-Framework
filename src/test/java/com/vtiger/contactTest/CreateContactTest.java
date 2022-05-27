package com.vtiger.contactTest;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateContactPage;

public class CreateContactTest extends BaseClass{
	@Test(groups = "sanity")
	public  void createContactTest() throws IOException {
		String contactname = ExcelLibrary.getDataFromExcel("contact", 2, 1)+JavaLibrary.getRandomNumber(1000);
		ContactPage contactPage=new ContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("contact", 5, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("contact", 5, 5, "pass");
		}
		homepage.clickContact();
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 6, 4, "Contacts page is displayed");
			ExcelLibrary.setDataToExcel("contact", 6, 5, "pass");
		}		
		contactPage.clickCreateContact();
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 7, 4, "Add Contacts page is displayed");
			ExcelLibrary.setDataToExcel("contact", 7, 5, "pass");
		}		
		createContactPage.createContact(contactname);
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 8, 4, "Contacts detail page is displayed");
			ExcelLibrary.setDataToExcel("contact", 8, 5, "pass");
		}		
		String contactname1 = contactInformationPage.getLastName();
		JavaLibrary.assertionThrouhIf(contactname, contactname1);
		Reporter.log(contactname+" created");
	}
}
