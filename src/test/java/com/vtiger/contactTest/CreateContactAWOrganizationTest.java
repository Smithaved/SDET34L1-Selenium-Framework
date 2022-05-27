package com.vtiger.contactTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.vtiger.ElementRepository.ContactInformationPage;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateContactPage;
import com.vtiger.ElementRepository.CreateOrganizationPage;
import com.vtiger.ElementRepository.OrganizationInpormationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class CreateContactAWOrganizationTest extends BaseClass{
	@Test(groups = "regression")
	public void createContactAWOrganizationTest() throws IOException, InterruptedException {
		String organizationname = ExcelLibrary.getDataFromExcel("contact", 13, 2)+JavaLibrary.getRandomNumber(1000);
		String contactname = ExcelLibrary.getDataFromExcel("contact", 13, 1)+JavaLibrary.getRandomNumber(1000);
		OrganizationPage organizationPage=new OrganizationPage(driver);
		OrganizationInpormationPage organizationInpormationPage=new OrganizationInpormationPage(driver);
		CreateOrganizationPage createOrganizationPage=new CreateOrganizationPage(driver);
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);
		homepage.clickOrganiztion();
		organizationPage.clickCreateOrganization();
		createOrganizationPage.createOrganization(organizationname);
		WebDriverLibrary.driverExplicitWait(longtimeout, driver);
		WebDriverLibrary.waitTillElementVisible(organizationInpormationPage.getAddresOfOrganizationName());
		homepage.clickContact();
		contactPage.clickCreateContact();
		createContactPage.createContactWithOrganization(contactname, driver, "Organization", organizationname, "Contacts");
		String contactname1 = contactInformationPage.getLastName();
		JavaLibrary.assertionThrouhIf(contactname, contactname1);
		Reporter.log(contactname+" created along with "+organizationname);
	}
}
