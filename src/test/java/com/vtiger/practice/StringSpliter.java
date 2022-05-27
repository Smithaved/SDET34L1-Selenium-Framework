package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StringSpliter {
	static WebDriver driver;
	
	 public static WebElement split(String s) { 
		 String[] str = s.split("###");
		 WebElement ele = null;
			switch (str[0]) {
			case "name":
					 ele = driver.findElement(By.name(str[1]));
				break;
			case "id":
				 ele=driver.findElement(By.id(str[1]));
			break;
			case "xpath":
				ele=driver.findElement(By.xpath(str[1]));
			break;
			default:
				break;
				
			}
			return ele;
	 }
	
	public static void main(String[] args) {
		String userName="name###user_name";
		String password="name###user_password";
		String login="id###submitButton";
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.get("http://localhost:8888");
		WebElement username = split(userName);
		WebElement pwd = split(password);
		WebElement Lbutton = split(login);
		username.sendKeys("admin");
		pwd.sendKeys("admin");
		Lbutton.click();
	}

}
