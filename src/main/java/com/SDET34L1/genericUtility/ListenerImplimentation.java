package com.SDET34L1.genericUtility;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is TestStart");
		 test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is TestSuccess");
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This is Failure");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Fail");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(WebDriverLibrary.takeScreenShorts(BaseClass.staticdriver,result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This is TestSkipped");
		test.log(Status.SKIP,result.getMethod().getMethodName()+" is Skiped");
		test.log(Status.SKIP,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("This is TestFailed");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("This is SuitStart");
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/extentReport.html");
		spark.config().setDocumentTitle("SDET34");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("TestNg Report");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Environment","TestNG Environment");
		report.setSystemInfo("Reporter Name","Smitha.S");
		report.setSystemInfo("Platform","Windows 8.1");
		report.setSystemInfo("Unit Testing Tool","TestNG");
		report.setSystemInfo("Build Management Tool","Maven");
		report.setSystemInfo("Automation","Selenium");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This is SuitFinish");
		report.flush();
	}
	

}
