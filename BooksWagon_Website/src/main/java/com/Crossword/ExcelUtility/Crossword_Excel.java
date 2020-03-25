package com.Crossword.ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Crossword_Excel
{

		//To read and return the username
		public  String excel_username(int a) throws IOException
		{	  
			
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));   //Create an object of FileInputStream class to read excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fil);   //Create an object of XSSFWorkbook class
			XSSFSheet sheet=workbook.getSheet("Sheet1"); //Read excel sheet by sheet name
			int count=sheet.getLastRowNum();  //Get the count of rows in excel file
			System.out.println(count);
			XSSFRow row =sheet.getRow(a); //Get the current rows in excel file
			XSSFCell cell=row.getCell(0); //Get the cell of First Row in excel file
			String un=cell.getStringCellValue();   //Get Cell Value and Storing the Value in String
             		return un;   //return the username value
		}
				
		//To read and return the password
		public  String excel_password(int b) throws IOException 
		{ 
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));	//Create an object of FileInputStream class to read excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fil);	//Create an object of XSSFWorkbook class
			XSSFSheet sheet=workbook.getSheet("Sheet1");	//Read excel sheet by sheet name
			int count=sheet.getLastRowNum();	//Get the count of rows in excel file
			System.out.println(count);
			XSSFRow row =sheet.getRow(b);	//Get the current rows in excel file
			XSSFCell cell1=row.getCell(1);	//Get the cell of Second Row in excel file
			String pwd=cell1.getStringCellValue();	//Get Cell Value and Storing the Value in String
			          
			return pwd;	//return the password value
		}
		
		
		//To read and return the mobile number
		public  String excel_mobile(int a) throws IOException
		{	  
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));	//Create an object of FileInputStream class to read excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fil);	//Create an object of XSSFWorkbook class
			XSSFSheet sheet=workbook.getSheet("Sheet1");	//Read excel sheet by sheet name
			int count=sheet.getLastRowNum();	//Get the count of rows in excel file
			System.out.println(count);	 
			XSSFRow row =sheet.getRow(a);	//Get the current rows in excel file
			XSSFCell cell=row.getCell(0);	//Get the cell of First Row in excel file
			cell.setCellType(CellType.STRING);	//Set the Cell type as String
			String mob=cell.getStringCellValue();	//Get Cell Value and Storing the Value in String
			
			return mob;	//return the mobile value
		}
						
		//To read and return the landline
		public  String excel_landline(int b) throws IOException 
		{ 
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));	//Create an object of FileInputStream class to read excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fil);	//Create an object of XSSFWorkbook class
			XSSFSheet sheet=workbook.getSheet("Sheet1");	//Read excel sheet by sheet name
			int count=sheet.getLastRowNum();	//Get the count of rows in excel file
			System.out.println(count);
			XSSFRow row =sheet.getRow(b);	//Get the current rows in excel file
			XSSFCell cell1=row.getCell(1);	//Get the cell of First Row in excel file
			cell1.setCellType(CellType.STRING);	//Set the Cell type as String
			String land=cell1.getStringCellValue();	//Get Cell Value and Storing the Value in String
					          
			return land;	//return the landline value
		}
}
