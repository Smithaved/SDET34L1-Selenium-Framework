package com.SDET34L1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains
 * @author USER
 *
 */
public class DatabaseLibrary {
	static Connection conn;
	static Statement stat;
	/**
	 * This method is used to connect to database
	 * @param path
	 * @param username
	 * @param password
	 */
	public static void openDbConnection(String path, String username, String password) 
	{
		Driver driver1 = null;
		try {
			driver1 = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(driver1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			conn=DriverManager.getConnection(path, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to get the data from database
	 * @param query
	 * @param columnName
	 * @return
	 */
	public static ArrayList<String> getDataFromDatabase( String query, String columnName) 
	{
		ArrayList<String> list=new ArrayList<>();
		
		ResultSet result = null;
		try {
			result = stat.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(result.next())
			{
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println("Error occured during geting the data from database");
				}			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	/**
	 * This method is used to validate
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 */
	public static boolean validateDataInDatabase( String query, String columnName, String expectedData) 
	{
		ArrayList<String> list = null;
		try {
			list = getDataFromDatabase( query, columnName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error occured during validation");
		}
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		return flag;
	}
	/**
	 * This method is used to update the database
	 * @param query
	 */
	public static void setDataInDatabase( String query) 
	{
		
		int result = 0;
		try {
			result = stat.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error occured during updating the database");
			
		}
		if(result>=1)
		{
			System.out.println("Data Entered or modified sucessfully");
		}
		
	}
	/**
	 * This method is used to close the connection of database
	 */
	public static void closeDatabase()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Error occured during clossing the database");
		}
	}
}
