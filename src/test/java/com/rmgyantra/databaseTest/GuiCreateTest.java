package com.rmgyantra.databaseTest;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.genericUtility.DatabaseLibrary;
import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuiCreateTest {
	public static void main(String[] args) throws SQLException {
		FilesLibrary.openPropertyFile(IconstantPath.RMGYANTRA);
		DatabaseLibrary.openDbConnection(IconstantPath.DATABASEPATH+FilesLibrary.fetchDataFromPropertyFile("projectname"), FilesLibrary.fetchDataFromPropertyFile("dbusername"), FilesLibrary.fetchDataFromPropertyFile("dbpassword"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("rmgusername"));
		driver.findElement(By.id("inputPassword")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("rmgpassword"));
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String pname = "SDET"+JavaLibrary.getRandomNumber(100);
		driver.findElement(By.name("projectName")).sendKeys(pname);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('form-control')[5].value=5");
		driver.findElement(By.name("createdBy")).sendKeys("Deepak");
		WebElement ele = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		Select s=new Select(ele);
		s.selectByIndex(2);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		boolean result = DatabaseLibrary.validateDataInDatabase("select project_name from project", "project_name", pname);		
		if(result)
		{
			System.out.println(pname+" added");
		}
		else
		{
			System.out.println(pname+" not added");
		}
		DatabaseLibrary.closeDatabase();
		driver.quit();
	}
}
