package com.vtiger.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.github.dockerjava.api.model.Driver;
import com.vtiger.ElementRepository.HomePage;
import com.vtiger.ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to perform the common actions for all the test cases
 * @author USER
 *
 */
public class BaseClass1 {
	public static WebDriver staticDriver;
	 String username;
	 String password;
	 public long longtimeout;
	 public  WebDriver driver;
	 public LoginPage loginpage;
	 public HomePage homepage;
	 
	 /**
	  * This method is used to open the external files
	  */
	@BeforeSuite
	public void beforesuitTest()
	{
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelLibrary.openExcel(IconstantPath.EXCELFILEPATH);
	}
	/**
	 * This method is used to launch the browser
	 */
	@Parameters("browser")
	@BeforeClass
	public void beforeclassTest(String browser)
	{
		String url=FilesLibrary.fetchDataFromPropertyFile("url");
		//String browser=FilesLibrary.fetchDataFromPropertyFile("browser");
		username=FilesLibrary.fetchDataFromPropertyFile("username");
		password=FilesLibrary.fetchDataFromPropertyFile("password");
	    longtimeout=JavaLibrary.stringToLong(FilesLibrary.fetchDataFromPropertyFile("timeout"));
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		staticDriver=driver;
		WebDriverLibrary.launchApplication(url, driver);
		WebDriverLibrary.maximizeBrowser(driver);
		WebDriverLibrary.waitTillBrowserLaunch(longtimeout, driver);
		loginpage=new LoginPage(driver);
		  homepage=new HomePage(driver);
	}
	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod
	public void beforemethodTest()
	{
		 loginpage.loginAction(username, password);
	}
	/**
	 * This method is used to logout from the application and to write to the excel
	 */
	@AfterMethod
	public void aftermethodTest()
	{
		homepage.logout(driver);
		ExcelLibrary.writeToExcel(IconstantPath.EXCELFILEPATH);
	}
	/**
	 * This method is used to close the browser
	 */
	@AfterClass
	public void afterclassTest()
	{
		WebDriverLibrary.quitBrowser(driver);
	}
	/**
	 * This method used to close the external files
	 */
	@AfterSuite
	public void aftersuiteTest()
	{
		ExcelLibrary.closeExcel();
	}
}
