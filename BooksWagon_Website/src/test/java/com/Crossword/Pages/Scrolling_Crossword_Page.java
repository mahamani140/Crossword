package com.Crossword.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Crossword.ExcelUtility.Crossword_Excel;

public class Scrolling_Crossword_Page
{

	WebDriver driver;
	
	//Scrolling the payment option page
	By payment = By.linkText("Payment Option");
	By takeMe = By.className("go-to-top");
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
	
	//Scrolling the payment option page
	public void scroll() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; //Create an object for Scrolling option
	    js.executeScript("window.scrollBy(0,1000)");
	    
	    Thread.sleep(1000);
	    driver.findElement(payment).click();	//Find and click the payment 
	    
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    
	    driver.findElement(takeMe).click();  //Find and click the take me button
	}
	
	
	public void close_scroll() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();	//Find and click the logout button
		Thread.sleep(2000);
		driver.close(); //To close the browser
	}
}
