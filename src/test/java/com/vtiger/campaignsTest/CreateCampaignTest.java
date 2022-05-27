package com.vtiger.campaignsTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.CampainInformationPage;
import com.vtiger.ElementRepository.CampainPage;
import com.vtiger.ElementRepository.CreateCampainPage;

public class CreateCampaignTest extends BaseClass {
	
	@Test
	public void createCampaignTest() throws IOException {
		String campaignname = ExcelLibrary.getDataFromExcel("Campaign", 2, 1)+JavaLibrary.getRandomNumber(1000);
		CampainPage campainpage=new CampainPage(driver);
		CreateCampainPage createcampainpage=new CreateCampainPage(driver);
		CampainInformationPage campaininformationpage=new CampainInformationPage(driver);
		homepage.clickCampain(driver);
		campainpage.clickCreateCampaign();
		createcampainpage.createCampain(campaignname);
		String campaignname1 = campaininformationpage.campaignName();
		JavaLibrary.assertionThrouhIf(campaignname, campaignname1);
		Reporter.log(campaignname+"created",true);
	}

}
