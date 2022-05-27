package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RmgDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Connection conn= null;
		String pname = null;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select project_name from project");
		while(result.next())
		{
			 pname = result.getString("project_name");
		}
		if(pname.contentEquals("SDET123"))
		{
			System.out.println("project added sucessfully");
		}
		else
		{
			System.out.println("project not added ");
		}
		conn.close();
		
	}

}
