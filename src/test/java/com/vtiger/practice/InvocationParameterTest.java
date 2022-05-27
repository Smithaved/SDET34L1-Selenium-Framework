package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationParameterTest {
	@Test(invocationCount = 2)
	public void practiceTest1(){
		Reporter.log("HI",true);
	}

	@Test()
	public void practiceTest2(){
		Reporter.log("Hello",true);
	}
	
	@Test(invocationCount = 0)
	public void practiceTest3(){
		Reporter.log("Hello word",true);
	}
}
