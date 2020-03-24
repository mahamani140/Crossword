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

	public void LaunchBrowser() throws IOException 
	{ 
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.crossword.in/");
		System.out.println(driver.getTitle());
		
		Crossword_Excel data = new Crossword_Excel();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_session_email")).sendKeys(data.excel_username(1)); 
		driver.findElement(By.id("user_session_password")).sendKeys(data.excel_password(1));
		driver.findElement(By.xpath("//*[@id=\"user_session_submit\"]")).click();
	}
	
	//To Add new address
	public void newAddress() throws InterruptedException
	{
		driver.findElement(myAccount).click();
		driver.findElement(myAccount).click();
		Thread.sleep(5000);
		driver.findElement(addressBook).click();
		Thread.sleep(3000);
		driver.findElement(newAddress).click();
		driver.findElement(addressName).sendKeys("Maha");
		driver.findElement(addressAddress).sendKeys("no.48,anna st");
				
		WebElement stateDropDown = driver.findElement(addressState);
		Select dropdown = new Select(stateDropDown);
		dropdown.selectByValue("West Bengal");
				
		driver.findElement(addressCity).sendKeys("kedar");
		driver.findElement(addressZip).sendKeys("600003");
		driver.findElement(addressMobile).sendKeys("9876543210");
		driver.findElement(addressLandline).sendKeys("04135444");
		driver.findElement(create).click();
	}
	
	public void close_address() throws InterruptedException
	{
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();
	}
	

}
