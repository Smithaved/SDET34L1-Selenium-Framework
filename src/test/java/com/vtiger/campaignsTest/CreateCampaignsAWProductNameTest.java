package com.vtiger.campaignsTest;

import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.vtiger.ElementRepository.CampainInformationPage;
import com.vtiger.ElementRepository.CampainPage;
import com.vtiger.ElementRepository.CreateCampainPage;
import com.vtiger.ElementRepository.CreateProductPage;
import com.vtiger.ElementRepository.ProductPage;

public class CreateCampaignsAWProductNameTest extends BaseClass{
	@Test
	public  void createCampaignsAWProductNameTest() throws Throwable {
		
		String campaignname = ExcelLibrary.getDataFromExcel("Campaign", 5, 1)+JavaLibrary.getRandomNumber(1000);
		String productname = ExcelLibrary.getDataFromExcel("Campaign", 5, 2)+JavaLibrary.getRandomNumber(1000);
		CampainPage campainPage=new CampainPage(driver);
		CreateCampainPage createCampainPage=new CreateCampainPage(driver);
		CampainInformationPage campainInformationPage=new CampainInformationPage(driver);
		ProductPage productPage=new ProductPage(driver);
		CreateProductPage createProductPage=new CreateProductPage(driver);
		homepage.clickProduct();
		productPage.clickCreateProduct();
		createProductPage.createProduct(productname);
		WebDriverLibrary.driverExplicitWait(longtimeout, driver);
		WebDriverLibrary.explicitWaitUntilElementisClickable(homepage.returnMoreLinkAddress());
		homepage.clickCampain(driver);
		campainPage.clickCreateCampaign();
		createCampainPage.createCampainWithProduct(campaignname, driver, "Product", productname, "Campaign");
		String campaignname1 = campainInformationPage.campaignName();
		JavaLibrary.assertionThrouhIf(campaignname1, campaignname);
	}

}
