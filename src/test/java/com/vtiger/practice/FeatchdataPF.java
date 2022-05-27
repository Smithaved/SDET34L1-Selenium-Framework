package com.vtiger.practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FeatchdataPF {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String browser = property.getProperty("browser");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println(timeout);
		
	}

}
