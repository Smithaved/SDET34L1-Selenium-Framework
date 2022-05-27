package com.SDET34L1.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.ElementRepository.HomePage;
import com.vtiger.ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is used to perform the common actions for all the test cases
 * @author USER
 *
 */
public class BaseClass{
	public static WebDriver staticdriver;
	 String username;
	 String password;
	 public long longtimeout;
	 public  WebDriver driver;
	 public LoginPage loginpage;
	 public HomePage homepage;
	 /**
	  * This method is used to open the external files
	  */
	@BeforeSuite(groups = "baseclass" )
	public void beforesuitTest()
	{
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelLibrary.openExcel(IconstantPath.EXCELFILEPATH);
	}
	/**
	 * This method is used to launch the browser
	 */
	@Parameters("browser")
	@BeforeClass(groups = "baseclass")
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
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		}
		staticdriver=driver;
		WebDriverLibrary.launchApplication(url, driver);
		WebDriverLibrary.maximizeBrowser(driver);
		WebDriverLibrary.waitTillBrowserLaunch(longtimeout, driver);
		loginpage=new LoginPage(driver);
		  homepage=new HomePage(driver);
	}
	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod(groups = {"baseclass"})
	public void beforemethodTest()
	{
		 loginpage.loginAction(username, password);
	}
	/**
	 * This method is used to logout from the application and to write to the excel
	 */
	@AfterMethod(groups = {"baseclass"})
	public void aftermethodTest()
	{
		homepage.logout(driver);
		ExcelLibrary.writeToExcel(IconstantPath.EXCELFILEPATH);
	}
	/**
	 * This method is used to close the browser
	 */
	@AfterClass(groups = "baseclass")
	public void afterclassTest()
	{
		WebDriverLibrary.quitBrowser(driver);
	}
	/**
	 * This method used to close the external files
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuiteTest()
	{
		ExcelLibrary.closeExcel();
	}
}
