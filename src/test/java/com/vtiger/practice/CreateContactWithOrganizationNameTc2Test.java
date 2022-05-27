package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import com.vtiger.ElementRepository.ContactPage;
import com.vtiger.ElementRepository.CreateContactPage;
import com.vtiger.ElementRepository.HomePage;
import com.vtiger.ElementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationNameTc2Test {
	public static void main(String[] args) 
	{
		WebDriver driver=null;
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		String url=FilesLibrary.fetchDataFromPropertyFile("url");
		String browser=FilesLibrary.fetchDataFromPropertyFile("browser");
		String username=FilesLibrary.fetchDataFromPropertyFile("username");
		String password=FilesLibrary.fetchDataFromPropertyFile("password");
		String timeout=FilesLibrary.fetchDataFromPropertyFile("timeout");
		ExcelLibrary.openExcel(IconstantPath.EXCELFILEPATH);
		String contactName = ExcelLibrary.getDataFromExcel("contact", 54, 1);
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		default:
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		}
		WebDriverLibrary.launchApplication(url, driver);
		WebDriverLibrary.maximizeBrowser(driver);
		WebDriverLibrary.waitTillBrowserLaunch(JavaLibrary.stringToLong(timeout), driver);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateContactPage ccp=new CreateContactPage(driver);
		
		if(driver.getTitle().contains("vtiger"))
		{
			ExcelLibrary.setDataToExcel("contact", 63, 4, "Login page is displayed");
			ExcelLibrary.setDataToExcel("contact", 63, 5, "Pass");
		}
		lp.loginAction(username, password);
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("contact", 64, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("contact", 64, 5, "Pass");
		}
		hp.clickContact();
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 65, 4, "Contacts list page is displayed");
			ExcelLibrary.setDataToExcel("contact", 65, 5, "Pass");
		}
		cp.clickCreateContact();
		String pagename = ccp.getHeaderText();
		if(pagename.equalsIgnoreCase("Creating New Contact"))
		{
			ExcelLibrary.setDataToExcel("contact", 66, 4, "Creating New Contact page is displayed");
			ExcelLibrary.setDataToExcel("contact", 66, 5, "Pass");
		}
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		WebDriverLibrary.switchToWindow(driver, "Organization");
		String windowname=driver.findElement(By.xpath("//td[.='Organizations']")).getText();
		if(windowname.equalsIgnoreCase("Organizations"))
		{
			ExcelLibrary.setDataToExcel("contact", 67, 4, "Organizations page is displayed in new window");
			ExcelLibrary.setDataToExcel("contact", 67, 5, "Pass");
		}
		String orgnaizationname = driver.findElement(By.xpath("//tr[2]/td/a")).getText();
		driver.findElement(By.xpath("//tr[2]/td/a")).click();
		WebDriverLibrary.switchToWindow(driver, "Contacts");
		String contactOrganizatonname = driver.findElement(By.xpath("//input[@name='account_name']")).getText();
		if(contactOrganizatonname.equals(orgnaizationname))
		{
			ExcelLibrary.setDataToExcel("contact", 68, 4, "Organization name is same");
			ExcelLibrary.setDataToExcel("contact", 68, 5, "Pass");
		}
		driver.findElement(By.xpath("//tr[1]/td[@colspan='4']//input[@title='Save [Alt+S]']")).click();
		String coninfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(coninfo.contains(contactName))
		{
			ExcelLibrary.setDataToExcel("contact", 69, 4, "Contact of "+contactName+" is created an the conformation message is displayed");
			ExcelLibrary.setDataToExcel("contact", 69, 5, "Pass");
		}
		ExcelLibrary.writeToExcel(IconstantPath.EXCELFILEPATH);
		ExcelLibrary.closeExcel();
		WebDriverLibrary.quitBrowser(driver);
	}

}
