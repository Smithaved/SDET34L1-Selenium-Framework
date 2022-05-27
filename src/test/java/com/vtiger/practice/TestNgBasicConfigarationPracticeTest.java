package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgBasicConfigarationPracticeTest {
	
	@BeforeSuite(groups = "baseclass")
	public void suite1Test()
	{
		Reporter.log("beforesuite1",true);
	}
	@BeforeSuite(groups = "baseclass")
	public void suite1Test2()
	{
		Reporter.log("beforesuite2",true);
	}
	@AfterSuite(groups = "baseclass")
	public void afterSuite1Test()
	{
		Reporter.log("aftersuite1",true);
	}
	@BeforeClass(groups = "baseclass")
	public void class1Test()
	{
		Reporter.log("beforeclass1",true);
	}
	@AfterClass(groups = "baseclass")
	public void afterClass1Test()
	{
		Reporter.log("afterclass1",true);
	}
	@BeforeTest(groups = "baseclass")
	public void beforeTest1Test()
	{
		Reporter.log("beforetest1",true);
	}
	@AfterTest(groups = "baseclass")
	public void afterTest1Test()
	{
		Reporter.log("aftertest1",true);
	}
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test()
	{
		Reporter.log("beforemethod1",true);
	}
	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test()
	{
		Reporter.log("aftermethod1",true);
	}
}
