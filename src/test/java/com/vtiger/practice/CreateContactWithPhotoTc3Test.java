package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET34L1.genericUtility.ExcelLibrary;
import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithPhotoTc3Test {

	public static void main(String[] args) {
		WebDriver driver=null;
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		String url=FilesLibrary.fetchDataFromPropertyFile("url");
		String browser=FilesLibrary.fetchDataFromPropertyFile("browser");
		String username=FilesLibrary.fetchDataFromPropertyFile("username");
		String password=FilesLibrary.fetchDataFromPropertyFile("password");
		String timeout=FilesLibrary.fetchDataFromPropertyFile("timeout");
		ExcelLibrary.openExcel(IconstantPath.EXCELFILEPATH);
		String contactName = ExcelLibrary.getDataFromExcel("contact", 78, 1);
		String path = ExcelLibrary.getDataFromExcel("contact", 78, 2);
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
		if(driver.getTitle().contains("vtiger"))
		{
			ExcelLibrary.setDataToExcel("contact", 86, 4, "Login page is displayed");
			ExcelLibrary.setDataToExcel("contact", 86, 5, "Pass");
		}
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.setDataToExcel("contact", 87, 4, "Home page is displayed");
			ExcelLibrary.setDataToExcel("contact", 87, 5, "Pass");
		}
		WebElement contactele = driver.findElement(By.xpath("//a[.='Contacts']"));
		WebDriverLibrary.mouseHoverOnElement(driver, contactele);
		contactele.click();
		if(driver.getTitle().contains("Contacts"))
		{
			ExcelLibrary.setDataToExcel("contact", 88, 4, "Contacts list page is displayed");
			ExcelLibrary.setDataToExcel("contact", 88, 5, "Pass");
		}
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String pagename = driver.findElement(By.xpath("//span[.='Creating New Contact']")).getText();
		if(pagename.equalsIgnoreCase("Creating New Contact"))
		{
			ExcelLibrary.setDataToExcel("contact", 89, 4, "Creating New Contact page is displayed");
			ExcelLibrary.setDataToExcel("contact", 89, 5, "Pass");
		}
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactName);
		WebDriverLibrary.initializeJs(driver);
		WebDriverLibrary.scroolTillElement(driver.findElement(By.name("imagename")));
		driver.findElement(By.name("imagename")).sendKeys(path);
		
		if(driver.findElement(By.name("imagename")).getText().equals(contactName))
		{
			ExcelLibrary.setDataToExcel("contact", 90, 4, "Other Window is displayed");
			ExcelLibrary.setDataToExcel("contact", 90, 5, "Pass");
			ExcelLibrary.setDataToExcel("contact", 91, 4, "Corresponding contact image is displayed");
			ExcelLibrary.setDataToExcel("contact", 91, 5, "Pass");
		}
		driver.findElement(By.xpath("//tr[1]/td[@colspan='4']//input[@title='Save [Alt+S]']")).click();
		String coninfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(coninfo.contains(contactName))
		{
			ExcelLibrary.setDataToExcel("contact", 92, 4, "Contact of "+contactName+" is created an the conformation message is displayed");
			ExcelLibrary.setDataToExcel("contact", 92, 5, "Pass");
		}
		ExcelLibrary.writeToExcel(IconstantPath.EXCELFILEPATH);
		ExcelLibrary.closeExcel();
		WebDriverLibrary.quitBrowser(driver);
	}

}
