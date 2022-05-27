package com.vtiger.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgGuiTest {

	public static void main(String[] args) {
		String text="";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//td[2]"));
		for(int i=ele.size()-1;i>=0;i--)
		{
			WebElement n = ele.get(i);
			 text = n.getText();
			 if(text.contentEquals("SDET123a"))
			 {
				 break;
			 }
					
		}
		if(text.contentEquals("SDET123a"))
		{
			System.out.println("project added sucessfully");
		}
		else
		{
			System.out.println("project not added ");
		}
		driver.close();
	}

}
