package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.IconstantPath;

public class DataProviderAnnotationTest extends TestNgBasicConfigarationPracticeTest{
	@Test(dataProvider="loginData")
	public void practiceTest(String username,String password){
		Reporter.log(username+"         "+password,true);
	}
	@DataProvider
	public Object[][] loginData()
	{
		ExcelLibrary.openExcel(IconstantPath.EXCELFILEPATH);
		return ExcelLibrary.getMultipleData("TestData");
		
	}
}
