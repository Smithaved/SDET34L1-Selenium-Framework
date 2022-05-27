package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependencyParameterTest {
	@Test(dependsOnMethods = "practiceTest2")
	public void practiceTest1(){
		Reporter.log("HI",true);
	}

	@Test()
	public void practiceTest2(){
		Reporter.log("Hello",true);
		Assert.fail();
	}
	
	@Test()
	public void practiceTest3(){
		Reporter.log("Hello word",true);
	}

}
