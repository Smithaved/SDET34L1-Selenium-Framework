package com.vtiger.productsTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.SDET34L1.genericUtility.BaseClass;
import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.vtiger.ElementRepository.CreateProductPage;
import com.vtiger.ElementRepository.ProductInformationPage;
import com.vtiger.ElementRepository.ProductPage;

public class CreateProductlTest extends BaseClass{
	@Test(groups = {"sanity","regression"})
	public  void createProductlTest() throws IOException {
		String productname = ExcelLibrary.getDataFromExcel("product",2,1)+JavaLibrary.getRandomNumber(1000);
		ProductPage productPage=new ProductPage(driver);
		CreateProductPage createProductPage=new CreateProductPage(driver);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		homepage.clickProduct();
		productPage.clickCreateProduct();
		createProductPage.createProduct(productname);
		String productname1 =productInformationPage.productName();
		JavaLibrary.assertionThrouhIf(productname, productname1);
		Reporter.log(productname+" created");
	}
}
