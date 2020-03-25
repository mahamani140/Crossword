package com.Crossword.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Crossword.ExcelUtility.Crossword_Excel;

public class NewAddress_Crossword_Page 
{
	WebDriver driver;
	
	//Add new Address
	By myAccount = By.linkText("My Account");
	By addressBook = By.linkText("Address Book");
	By newAddress = By.id("new-addr-link");
	By addressName = By.id("address_name");
	By addressAddress = By.id("address_address");
	By addressState = By.className("state_select");
	By addressCity =By.id("address_city");
	By addressZip =By.id("address_zip");
	By addressMobile =By.id("address_mobile");
	By addressLandline = By.id("address_landline");
	By create = By.id("address_submit");
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
	
	//To Add new address
	public void newAddress() throws InterruptedException
	{
		driver.findElement(myAccount).click(); //Find and Click the Myaccount Button
		driver.findElement(myAccount).click();	//Find and Click the Myaccount
		Thread.sleep(5000);
		driver.findElement(addressBook).click();	//Find and Click the addressBook option
		Thread.sleep(3000);
		driver.findElement(newAddress).click();		//Find and Click the Add new address button
		driver.findElement(addressName).sendKeys("Maha");	//Find the address name and send the name
		driver.findElement(addressAddress).sendKeys("no.48,anna st");	//Find the address and send the address
				
		WebElement stateDropDown = driver.findElement(addressState);	//find the state
		Select dropdown = new Select(stateDropDown);	//Create an object for select state
		dropdown.selectByValue("West Bengal");	//Select the state by SelectByValue
				
		driver.findElement(addressCity).sendKeys("kedar");	//Find the city and send city name
		driver.findElement(addressZip).sendKeys("600003");	//Find the zipcode and send zipcode
		driver.findElement(addressMobile).sendKeys("9876543210");	//Find the mobile  and send mobile number
		driver.findElement(addressLandline).sendKeys("04135444");	//Find the landline and send landline number
		driver.findElement(create).click();	//Find and Click the create button
	}
	//To Close
	public void close_address() throws InterruptedException
	{
		driver.findElement(By.linkText("Logout")).click();	//Find and click the logout button
		Thread.sleep(2000);
		driver.close();	//To close the browser
	}
	

}
