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

public class CreateProductTest {
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
		String pn="abc";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(JavaLibrary.stringToLong(FilesLibrary.fetchDataFromPropertyFile("timeout")), TimeUnit.SECONDS);
		driver.get(FilesLibrary.fetchDataFromPropertyFile("url"));
		driver.findElement(By.name("user_name")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("username"));
		driver.findElement(By.name("user_password")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(pn);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String pn1 = driver.findElement(By.id("dtlview_Product Name")).getText();
		if(pn1.equals(pn))
		{
			System.out.println("Product added");
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
