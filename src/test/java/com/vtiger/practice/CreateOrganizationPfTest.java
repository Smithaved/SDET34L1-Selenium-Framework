package com.vtiger.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationPfTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		FilesLibrary.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
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
		String on="vvss";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(JavaLibrary.stringToLong(FilesLibrary.fetchDataFromPropertyFile("timeout")), TimeUnit.SECONDS);
		driver.get(FilesLibrary.fetchDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(on);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		String on1 = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(on1.equals(on))
		{
			System.out.println("Organization added");
			System.out.println("TC pass");
		}
		else
		{
			System.out.println("TC fail");	
		}
		WebElement adm = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(adm).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();

	}

}
