package com.SDET34L1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This File is used to store the Excel specific common methods
 * @author USER
 *
 */
public class ExcelLibrary 
{
	static Workbook wb;
	/**
	 * This method is used to fetch the data from excel sheet
	 * @param filepath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) 
	{

		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return(data);
	}
	/**
	 * this method is used to open excel
	 * @param filepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String filepath) 
	{
		FileInputStream fis1 = null;
		try {
			fis1 = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem ocurred while opening filepath of excel");
		}
		try {
			wb = WorkbookFactory.create(fis1);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem ocurred while creating excel");
		}

	}
	/**
	 * This method is used to Set data  data to excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param message
	 */
	public static void setDataToExcel(String sheetName, int rowNumber, int cellNumber, String message)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(message);
	}
	/**
	 * this method is use to write to excel
	 * @param filepath
	 * @throws IOException
	 */
	public static void writeToExcel(String filepath) 
	{
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Problem ocurred while Seting filepath of excel");
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem ocurred while writing to excel");
		}
	}
/**
 * This method is used to close excel
 */
	public static void closeExcel() 
	{
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem ocurred while closing excel");
		}
	}
	/**
	 * This method is used to fetch the multiple data from excel
	 * @param sheetname
	 * @return
	 */
	public static Object[][] getMultipleData(String sheetname)
	{
		Sheet sh = wb.getSheet(sheetname);
		Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
}
