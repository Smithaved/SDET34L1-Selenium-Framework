package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestngPractice1Test extends TestNgBasicConfigarationPracticeTest{
	
	@Test(groups = "sanity")
	
	public void practice(){
		Reporter.log("Hi",true);
		Assert.fail();
	}
	@Test(groups = "regression")
	public void practice1(){
		System.out.println("Hello");
	}
	@Test(groups = {"regression","sanity"})
	public void practice2(){
		System.out.println("Helloword");
	}
}
