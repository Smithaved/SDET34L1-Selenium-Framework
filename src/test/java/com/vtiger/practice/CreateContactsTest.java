package com.vtiger.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']"));
		System.out.println(ele.getText());
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smitha");
//		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
//		String text = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
//		System.out.println(text);
//		if(text.contentEquals("Smitha"))
//		{
//			System.out.println("Contact is added and text case passed");
//		}
//		else
//		{
//			System.out.println("Contact is notadded and text case faild");	
//		}
//		WebElement adm = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act= new Actions(driver);
//		act.moveToElement(adm).perform();
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
//		driver.close();
	}
}
