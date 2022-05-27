package com.vtiger.practice;

public class TwoDimensionalArrayTest {

	public static void main(String[] args) {
		String[][] arr=new String[3][2];
		arr[0][0]="Karnataka";
		arr[0][1]="Bangalore";
		arr[1][0]="Tamilnadu";
		arr[1][1]="Chenni";
		arr[2][0]="Telengana";
		arr[2][1]="Hydrabad";
		for(int i=0;i<=arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				System.out.println(arr[i][j]);
			}
		}
	}

}
