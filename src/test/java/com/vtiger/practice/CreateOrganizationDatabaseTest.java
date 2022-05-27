package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationDatabaseTest {

	public static void main(String[] args) throws SQLException {
		String name=null;
		WebDriver driver1 = null;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet data = statement.executeQuery("select * from launch_login");
		String browser = null;
		String url = null;
		String uname = null;
		String time = null;
		String pwd = null;
		while(data.next())
		{
			browser=data.getString("browser");
			url=data.getString("url");
			time=data.getString("timeout");
			uname=data.getString("uname");
			pwd=data.getString("password");
		}
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver1=new ChromeDriver();
			driver1.manage().window().maximize();
			break;
        case "firefox":
        	WebDriverManager.firefoxdriver().setup();
			driver1=new FirefoxDriver();
			driver1.manage().window().maximize();
			break;	
		default:
			WebDriverManager.iedriver().setup();
			driver1=new InternetExplorerDriver();
			driver1.manage().window().maximize();
			break;
		}
		long longTimeout=Long.parseLong(time);
		driver1.get(url);
		driver1.manage().timeouts().implicitlyWait(longTimeout,TimeUnit.SECONDS);
		driver1.findElement(By.name("user_name")).sendKeys(uname);
		driver1.findElement(By.name("user_password")).sendKeys(pwd);
		driver1.findElement(By.id("submitButton")).click();
		
		ResultSet result = statement.executeQuery("select * from vtigerorg where Organization_name='ABCD'");
		while(result.next())
		{
			name=result.getString("Organization_name");
		}
		driver1.findElement(By.xpath("//a[.='Organizations']")).click();
		driver1.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver1.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		driver1.findElement(By.xpath("//input[@accesskey='S']")).click();
		String text = driver1.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(name.equals(text)) {
			System.out.println("Organization added");
			System.out.println("TC pass");
		}
		connection.close();
		driver1.close();

	}

}
