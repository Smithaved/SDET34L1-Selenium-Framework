package com.vtiger.documentsTest;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.CreateDocumentPage;
import com.vtiger.ElementRepository.DocumentInformationPage;
import com.vtiger.ElementRepository.DocumentPage;

public class CreateDocumentTest extends BaseClass{
	@Test(groups = {"sanity","regression"})
	public void createDocumentTest() throws Throwable {
		String docmumentname = ExcelLibrary.getDataFromExcel("Documents", 2, 1)+JavaLibrary.getRandomNumber(1000);
		String paragrah = ExcelLibrary.getDataFromExcel("Documents", 2, 2);
		String path = ExcelLibrary.getDataFromExcel("Documents", 2, 3);
		DocumentPage documentPage=new DocumentPage(driver);
		CreateDocumentPage createDocumentPage=new CreateDocumentPage(driver);
		DocumentInformationPage documentInformationPage=new DocumentInformationPage(driver);
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("Documents", 5, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("Documents", 5, 5, "pass");
		}
		homepage.clickDocument();
		if(driver.getTitle().contains("Documents"))
		{
			ExcelLibrary.setDataToExcel("Documents", 6, 4, "Documents page is displayed");
			ExcelLibrary.setDataToExcel("Documents", 6, 5, "Pass");
		}
		documentPage.clickCreateDocument();
		if(createDocumentPage.getDocumentName().contains("Creating New Document"));
		{
			ExcelLibrary.setDataToExcel("Documents", 7, 4, "Creating New Document page is displayed");
			ExcelLibrary.setDataToExcel("Documents", 7, 5, "Pass");
		}
		createDocumentPage.createDocumnet(docmumentname, driver, paragrah, path);
		if(documentInformationPage.getHeaderText().contains("Document Information"));
		{
			JavaLibrary.printStatement("Document created");
			ExcelLibrary.setDataToExcel("Documents", 8, 4, "Document Information page is displayed");
			ExcelLibrary.setDataToExcel("Documents", 8, 5, "Pass");
		}
		if(driver.getCurrentUrl().contains("Login"));
		{
			ExcelLibrary.setDataToExcel("Documents", 9, 4, "login page is displayed");
			ExcelLibrary.setDataToExcel("Documents", 9, 5, "Pass");
		}
		
		Reporter.log(docmumentname+" added",true);
	}

}
