package com.vtiger.organizationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.CreateOrganizationPage;
import com.vtiger.ElementRepository.OrganizationInpormationPage;
import com.vtiger.ElementRepository.OrganizationPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{
	@Test(groups = {"regression","sanity"})
	public void createOrganizationWithIndustryAndTypeTest() throws IOException, InterruptedException {
		
		String organizationname = ExcelLibrary.getDataFromExcel("organization", 12, 1)+JavaLibrary.getRandomNumber(1000);
		String industry=ExcelLibrary.getDataFromExcel("organization", 12, 2);
		String type=ExcelLibrary.getDataFromExcel("organization", 12, 3);
		OrganizationPage organizationPage=new OrganizationPage(driver);
		CreateOrganizationPage createOrganizationPage=new CreateOrganizationPage(driver);
		OrganizationInpormationPage organizationInpormationPage=new OrganizationInpormationPage(driver);
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("organization", 15, 4, "Home page is diaplayed");
			ExcelLibrary.setDataToExcel("organization", 15, 5, "pass");
		}
		homepage.clickOrganiztion();
		if(driver.getTitle().contains("Organizations"))
		{
			ExcelLibrary.setDataToExcel("organization", 16, 4, "Organization page is displayed");
			ExcelLibrary.setDataToExcel("organization", 16, 5, "pass");
		}
		organizationPage.clickCreateOrganization();
		String title=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(title.contains("Creating New Organization"))
		{
			ExcelLibrary.setDataToExcel("organization", 17, 4, "Creating New Organization page is displayed");
			ExcelLibrary.setDataToExcel("organization", 17, 5, "pass");
		}
		createOrganizationPage.createOrganizationWithIndustryAndType(organizationname, industry, type);
		if(organizationInpormationPage.getHeaderText().contains("Organization Information"))
		{
			ExcelLibrary.setDataToExcel("organization", 18, 4, "Organization Information page is displayed");
			ExcelLibrary.setDataToExcel("organization", 18, 5, "pass");
		}
		String organizationname1 = organizationInpormationPage.getOrganizationName();
		String industry1 = organizationInpormationPage.getIndustry();
		String type1=organizationInpormationPage.getType();
		JavaLibrary.assertionThrouhIf(organizationname, organizationname1);
		JavaLibrary.assertionThrouhIf(industry, industry1);	
		JavaLibrary.assertionThrouhIf(type, type1);
		Reporter.log(organizationname+" created along with "+industry+" and "+type,true);
		}
}
