package com.vtiger.organizationTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.CreateOrganizationPage;
import com.vtiger.ElementRepository.OrganizationInpormationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	@Test(groups = "sanity")
	public void createOrganizationTest() throws IOException {
		String organizationname = ExcelLibrary.getDataFromExcel("organization", 2, 1)+JavaLibrary.getRandomNumber(1000);
		OrganizationPage organizationPage=new OrganizationPage(driver);
		CreateOrganizationPage createOrganizationPage=new CreateOrganizationPage(driver);
		OrganizationInpormationPage organizationInpormationPage=new OrganizationInpormationPage(driver);
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("organization", 5, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("organization", 5, 5, "Pass");
		}
		homepage.clickOrganiztion();
		if(driver.getTitle().contains("Organizations "))
		{
			ExcelLibrary.setDataToExcel("organization", 6, 4, "Organization page is displayed");
			ExcelLibrary.setDataToExcel("organization", 6, 5, "Pass");
		}
		organizationPage.clickCreateOrganization();
		if(driver.getTitle().contains("Organizations "))
		{
			ExcelLibrary.setDataToExcel("organization", 7, 4, "Create Organization page is displayed");
			ExcelLibrary.setDataToExcel("organization", 7, 5, "Pass");
		}
		createOrganizationPage.createOrganization(organizationname);
		if(driver.getTitle().contains("Organizations "))
		{
			ExcelLibrary.setDataToExcel("organization", 8, 4, "Organization information page is displayed");
			ExcelLibrary.setDataToExcel("organization", 8, 5, "Pass");
		}
		String organizationname1 = organizationInpormationPage.getOrganizationName();
		JavaLibrary.assertionThrouhIf(organizationname, organizationname1);
		Reporter.log(organizationname+" created",true);
	}
}
	
