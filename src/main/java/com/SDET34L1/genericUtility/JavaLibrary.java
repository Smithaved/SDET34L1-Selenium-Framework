package com.SDET34L1.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific reusable methods
 * @author USER
 *
 */
public class JavaLibrary {
	/**
	 * This method is used to covert string value to long value
	 * @param value
	 * @return
	 */
	public static long stringToLong(String value)
	{
		return(Long.parseLong(value));
	}
	/**
	 * This method is used to get the random number
	 * @param limit
	 * @return
	 */
	public static int getRandomNumber(int limit)
	{
		Random rnd= new Random ();
		return(rnd.nextInt(limit));
	}
	/**
	 * This is used to print message
	 * @param message
	 */
	public static void printStatement(String message)
	{
		System.out.println(message);
	}
	/**
	 * This function is used to check the matching conditions
	 * @param expectedResult
	 * @param actualResult
	 */
	public static void assertionThrouhIf(String expectedResult, String actualResult)
	{
		if(actualResult.equals(expectedResult))
		{
			System.out.println(expectedResult+" is added");
			System.out.println("Testcase is passed");
		}
		else
		{
			System.out.println("Organization is notadded and text case faild");	
		}
	}
	/**
	 * This method is used to wait until element is clickable
	 * @param element
	 * @param polingTime
	 * @param duration
	 */
	public static void customWait(WebElement element,long polingTime,int duration)
	{
		int count=0;
		while(count<=duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e){
				try {
					Thread.sleep(polingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * This method is used to get the date 
	 * @return
	 */
	public static String dateFormat()
	{
		return(new SimpleDateFormat("dd-mm-yyyy-HH-ss").format(new Date()));
	}

}
