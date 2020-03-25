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
	
	//To Update Profile
	public void updateProfile(int a) throws IOException, InterruptedException
	{
		Crossword_Excel data = new Crossword_Excel();
		Thread.sleep(1000);
		driver.findElement(myAccount).click();
		Thread.sleep(3000);
		driver.findElement(updateProfile).click();
		driver.findElement(mobile).sendKeys(data.excel_mobile(a));
		driver.findElement(landLine).sendKeys(data.excel_landline(a));
		driver.findElement(updateButton).click();
	}
	
	public void close_updateProfile() throws InterruptedException
	{
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
}
