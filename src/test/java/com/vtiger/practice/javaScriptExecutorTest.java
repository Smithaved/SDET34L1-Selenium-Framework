package com.vtiger.practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.SDET34L1.genericUtility.JavaLibrary;
import com.SDET34L1.genericUtility.WebDriverLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutorTest {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverLibrary.initializeJs(driver);
		WebDriverLibrary.navigateThroughJs("http://Localhost:8888");
		driver.manage().window().maximize();
		WebDriverLibrary.sendDataThroughJs(driver.findElement(By.name("user_name")), "admin");
		WebDriverLibrary.sendDataThroughJs(driver.findElement(By.name("user_password")), "admin");
		WebDriverLibrary.clickThroughJs(driver.findElement(By.id("submitButton")));
		WebDriverLibrary.scroolToBottomHeight();
		WebDriverLibrary.scroolTillElement(driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]")));
	    String fileName = new javaScriptExecutorTest().getClass().getName()+JavaLibrary.getRandomNumber(10);
	    WebDriverLibrary.takeScreenShorts(driver, fileName);
	   	}
}
