package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityParameterTest {
	@Test(priority = 3)
	public void practiceTest1(){
		Reporter.log("HI",true);
	}

	@Test()
	public void practiceTest2(){
		Reporter.log("Hello",true);
	}
	
	@Test(priority = 1)
	public void practiceTest3(){
		Reporter.log("Hello word",true);
	}
}
