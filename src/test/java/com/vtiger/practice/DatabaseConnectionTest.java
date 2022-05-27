package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnectionTest {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		try
		{
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34l1", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from sdet34");
			while(result.next())
			{
				System.out.println(result.getString(1)+"   "+result.getString(2)+"   "+result.getString(3));
			}
		}
		finally {
			connection.close();
		}
	}
}
