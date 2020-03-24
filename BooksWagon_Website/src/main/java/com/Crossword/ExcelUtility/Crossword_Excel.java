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
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fil);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int count=sheet.getLastRowNum();
			System.out.println(count);	    
			XSSFRow row =sheet.getRow(a);
			XSSFCell cell=row.getCell(0);
			String un=cell.getStringCellValue();
						  
			return un;
		}
				
		//To read and return the password
		public  String excel_password(int b) throws IOException 
		{ 
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fil);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int count=sheet.getLastRowNum();
			System.out.println(count);
			XSSFRow row =sheet.getRow(b);
			XSSFCell cell1=row.getCell(1);
			String pwd=cell1.getStringCellValue();
			          
			return pwd;
		}
		
		
		//To read and return the mobile number
		public  String excel_mobile(int a) throws IOException
		{	  
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fil);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int count=sheet.getLastRowNum();
			System.out.println(count);	 
			XSSFRow row =sheet.getRow(a);
			XSSFCell cell=row.getCell(0);
			cell.setCellType(CellType.STRING);
			String mob=cell.getStringCellValue();	
			
			return mob;
		}
						
		//To read and return the landline
		public  String excel_landline(int b) throws IOException 
		{ 
			FileInputStream fil = new FileInputStream(new File("src\\test\\resources\\TestData\\testdata.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fil);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int count=sheet.getLastRowNum();
			System.out.println(count);
			XSSFRow row =sheet.getRow(b);
			XSSFCell cell1=row.getCell(1);
			cell1.setCellType(CellType.STRING);
			String land=cell1.getStringCellValue();
					          
			return land;
		}
}
