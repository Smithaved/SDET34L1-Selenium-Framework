package com.SDET34L1.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentation implements IRetryAnalyzer{
	int count=0;
	int maxRetry=4;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<maxRetry)
		{
			count++;
			return true;
		}
		return false;
	}

}
