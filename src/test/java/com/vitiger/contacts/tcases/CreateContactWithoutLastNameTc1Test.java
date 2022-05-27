package com.vitiger.contacts.tcases;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateContactPage;

public class CreateContactWithoutLastNameTc1Test extends BaseClass {
	@Test
	public  void createContactWithoutLastNameTc1Test() throws Throwable 
	{
		
		String contactFirstName = ExcelLibrary.getDataFromExcel("contact", 35, 1)+JavaLibrary.getRandomNumber(1000);
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);
		if(driver.getTitle().contains("vtiger"))
		{
			ExcelLibrary.setDataToExcel("contact", 43, 4, "Login page is displayed");
			ExcelLibrary.setDataToExcel("contact", 43, 5, "Pass");
		}
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("contact", 44, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("contact", 44, 5, "Pass");
		}
		
		homepage.mouseHoverAndClickContact(driver);
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 45, 4, "Contacts list page is displayed");
			ExcelLibrary.setDataToExcel("contact", 45, 5, "Pass");
		}
		
		contactPage.clickCreateContact();
		String pagename = createContactPage.getHeaderText();
		if(pagename.equalsIgnoreCase("Creating New Contact"))
		{
			ExcelLibrary.setDataToExcel("contact", 46, 4, "Creating New Contact page is displayed");
			ExcelLibrary.setDataToExcel("contact", 46, 5, "Pass");
		}
		String message=createContactPage.checkAlertPopup( driver, contactFirstName);
		if(message.contains("Last Name cannot be empty"))
		{
			System.out.println("Error message is displayed");
			ExcelLibrary.setDataToExcel("contact", 47, 4, "Alert message Last Name cannot be empty is displayed");
			ExcelLibrary.setDataToExcel("contact", 47, 5, "Pass");
		}
		else
		{
			System.out.println("Error message is not displayed");
			ExcelLibrary.setDataToExcel("contact", 47, 4, "Alert message Last Name cannot be empty is not displayed");
			ExcelLibrary.setDataToExcel("contact", 47, 5, "Fail");
		}
		WebDriverLibrary.alertAccept(driver);
		
	}

}
