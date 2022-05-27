package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TestNgAssertTest {
	//SoftAssert softAssert=new SoftAssert();
	@Test
	public void practiceTest1()
	{
		Reporter.log("a-practice1",true);
		Reporter.log("b-practice1",true);
		Reporter.log("c-practice1",true);
		Assert.fail("practice1 fail");
		Reporter.log("d-practice1",true);
		Reporter.log("e-practice1",true);
		Reporter.log("f-practice1",true);
		Reporter.log("g-practice1",true);
	}
	@Test
	public void practiceTest2()
	{
		Reporter.log("a-practice2",true);
		Reporter.log("b-practice2",true);
		Reporter.log("c-practice2",true);
		Assert.assertEquals("abc", "abd");
		Reporter.log("d-practice2",true);
		Reporter.log("e-practice2",true);
		Reporter.log("f-practice2",true);
		Reporter.log("g-practice2",true);
	}
	@Test
	public void practiceTest3()
	{
		Reporter.log("a-practice3",true);
		Reporter.log("b-practice3",true);
		Reporter.log("c-practice3",true);
		Reporter.log("d-practice3",true);
		String a="abc";
		Assert.assertTrue(a.contains("ab"));
		Reporter.log("e-practice3",true);
		Reporter.log("f-practice3",true);
		//softAssert.assertEquals("abc", "abd");
		Reporter.log("g-practice3",true);
	}
	@Test
	public void practiceTest4()
	{
		
		Reporter.log("a-practice4",true);
		Reporter.log("b-practice4",true);
		//softAssert.assertEquals("abc", "abd");
		Reporter.log("c-practice4",true);
		
		//softAssert.assertEquals("abc", "abd");
		Reporter.log("d-practice4",true);
		//softAssert.assertEquals("abc", "abd");
		Reporter.log("e-practice4",true);
		//softAssert.assertAll();
		Reporter.log("f-practice4",true);
		Reporter.log("g-practice4",true);
	}
	@Test
	public void practiceTest5()
	{
		Reporter.log("a-practice4",true);
		Reporter.log("b-practice4",true);
		Reporter.log("c-practice4",true);
		Assert.fail();
		Reporter.log("d-practice4",true);
		Reporter.log("e-practice4",true);
		Reporter.log("f-practice4",true);
		Reporter.log("g-practice4",true);
	}
}
