package com.Crossword.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Crossword.ExcelUtility.Crossword_Excel;

public class UpdateProfile_Crossword_Page
{

	WebDriver driver;
	
	//Updating the profile details
	By myAccount = By.linkText("My Account");
	By updateProfile = By.linkText("Update Profile");
	By mobile =By.id("customer_mobile");
	By landLine = By.id("customer_landline");
	By updateButton =By.id("customer_submit");
	
	//To Launch Browser
	public void LaunchBrowser() throws IOException 
	{ 
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");	//Set path to chromedriver.exe
		driver = new ChromeDriver();	//create chrome instance
		driver.manage().window().maximize();	//To Maximize the window
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	//Time to wait
		driver.get("https://www.crossword.in/");	//Get the crossword url
		System.out.println(driver.getTitle());	//To get the title
		
		Crossword_Excel data = new Crossword_Excel();	//Create an object for excel 
		driver.findElement(By.linkText("Login")).click();	//Find Login Button
		driver.findElement(By.id("user_session_email")).sendKeys(data.excel_username(1)); //Find username and send username by excel sheet
		driver.findElement(By.id("user_session_password")).sendKeys(data.excel_password(1));	//Find password and send password by excel sheet
		driver.findElement(By.xpath("//*[@id=\"user_session_submit\"]")).click();	//Click the submit Button
	}
	
	//To Update Profile
	public void updateProfile(int a) throws IOException, InterruptedException
	{
		Crossword_Excel data = new Crossword_Excel();	//Create an object for excel file
		Thread.sleep(1000);
		driver.findElement(myAccount).click();	//Find and click the myaccount option
		Thread.sleep(3000);
		driver.findElement(updateProfile).click();	//Find and click the update profile option
		driver.findElement(mobile).sendKeys(data.excel_mobile(a));	//Find the mobile element and send mobile number by excel file
		driver.findElement(landLine).sendKeys(data.excel_landline(a));	//Find the landline element and send landline number by excel file
		driver.findElement(updateButton).click();	//Find and click the update button
	}
	
	public void close_updateProfile() throws InterruptedException
	{
		driver.findElement(By.linkText("Logout")).click(); //Find and click the logout
		Thread.sleep(2000);
		driver.close();	//To close the browser
	}
	
}
