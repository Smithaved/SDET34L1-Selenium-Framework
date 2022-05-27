package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import com.SDET34L1.genericUtility.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationGenericTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("organization");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(1);
		String on = cell.getStringCellValue()+JavaLibrary.getRandomNumber(1000);
		switch (FilesLibrary.fetchDataFromPropertyFile("browser")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(JavaLibrary.stringToLong(FilesLibrary.fetchDataFromPropertyFile("timeout")), TimeUnit.SECONDS);
		driver.get(FilesLibrary.fetchDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
		{
			sh.getRow(14).createCell(7).setCellValue("Home page is displayed");
			sh.getRow(14).createCell(8).setCellValue("pass");
		}
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		if(driver.getTitle().contains("Organizations "))
		{
			sh.getRow(15).createCell(7).setCellValue("Organizations page is displayed");
			sh.getRow(15).createCell(8).setCellValue("Pass");
		}
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		if(driver.getTitle().contains("Organizations "))
		{
			sh.getRow(16).createCell(7).setCellValue("Add Organizations page is displayed");
			sh.getRow(16).createCell(8).setCellValue("pass");
		}
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(on);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		if(driver.getTitle().contains("Organizations "))
		{
			sh.getRow(17).createCell(7).setCellValue("Organizations detail page is displayed");
			sh.getRow(17).createCell(8).setCellValue("pass");
		}
		String on1 = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(on1.equals(on))
		{
			System.out.println("Organization is added and text case passed");
		}
		else
		{
			System.out.println("Organization is notadded and text case faild");	
		}
		WebElement adm = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(adm).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		if(driver.getTitle().contains("vtiger "))
		{
			sh.getRow(18).createCell(7).setCellValue("Login page is displayed");
			sh.getRow(18).createCell(8).setCellValue("Pass");
		}
		driver.close();
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
}

