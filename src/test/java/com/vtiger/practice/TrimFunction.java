package com.vtiger.practice;

public class TrimFunction {

	public static void main(String[] args) {
		String s1="Smitha";
		String s2="Smitha ";
		if(s1.equals(s2))
		{
			System.out.println("Strings are same");
		}
		else
		{
			System.out.println("Strings are not same");
		}
		if(s1.equals(s2.trim()))
		{
			System.out.println("Strings are same");
		}
		else
		{
			System.out.println("Strings are not same");
		}
	}

}
