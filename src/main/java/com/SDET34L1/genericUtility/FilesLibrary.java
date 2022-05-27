package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only Property file specific common method
 * @author USER
 *
 */
public class FilesLibrary {
	static Properties property;
	/**
	 * This method is used to open the property file
	 * @throws IOException
	 */
	public static void openPropertyFile(String filepath) 
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Problem ocurred while Seting filepath of property file");
		}
	    property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem ocurred while loading property keys");
		}
	}
	/**
	 * This method is used to fetch data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String fetchDataFromPropertyFile(String key) 
	{
		String value = property.getProperty(key);
		return(value);
	}
}
