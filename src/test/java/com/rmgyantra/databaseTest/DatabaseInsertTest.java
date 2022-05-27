package com.rmgyantra.databaseTest;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1.genericUtility.DatabaseLibrary;
import com.SDET34L1.genericUtility.FilesLibrary;
import com.SDET34L1.genericUtility.IconstantPath;
import com.SDET34L1.genericUtility.JavaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseInsertTest {

	public static void main(String[] args) throws SQLException {
		FilesLibrary.openPropertyFile(IconstantPath.RMGYANTRA);
		DatabaseLibrary.openDbConnection(IconstantPath.DATABASEPATH+FilesLibrary.fetchDataFromPropertyFile("projectname"), FilesLibrary.fetchDataFromPropertyFile("dbusername"), FilesLibrary.fetchDataFromPropertyFile("dbpassword"));
		String pname="SDET34"+JavaLibrary.getRandomNumber(100);
		DatabaseLibrary.setDataInDatabase("insert into project values('TY_PROJ_"+JavaLibrary.getRandomNumber(100)+"','Deekap','27/04/2022','"+pname+"','ON GOING','5')");
		DatabaseLibrary.closeDatabase();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("rmgusername"));
		driver.findElement(By.id("inputPassword")).sendKeys(FilesLibrary.fetchDataFromPropertyFile("rmgpassword"));
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//td[2]"));
		for(WebElement project:ele)
		{
			if(project.getText().equals(pname))
			{
				System.out.println("project visible in GUI");
			}
		}
		driver.quit();
	}
}
