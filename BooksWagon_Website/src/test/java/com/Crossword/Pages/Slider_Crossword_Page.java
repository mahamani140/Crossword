package com.Crossword.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Crossword.ExcelUtility.Crossword_Excel;

public class Slider_Crossword_Page 
{

	WebDriver driver;
	
	By book = By.xpath("//*[@id=\"nav-menu-915599\"]/ul/li[2]/a");
	By price = By.xpath("//*[@id=\"facet-price\"]/h6");
	By slider = By.xpath("//*[@id=\"range_as_slider\"]/div[1]/a[1]");
	
	
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
	
	//Slider handling the price range
	public void slider() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(book).click();	//Find and click the book element
		driver.findElement(price).click();	//Find and click the price 
		WebElement Slider = driver.findElement(slider);	//Create an object for slider element
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(Slider).moveByOffset(40,0).release().build(); //To move the slider by drag and drop operation
		dragAndDrop.perform(); //To perform drag and drop operation
	}
	
	public void close_slider() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();	//Find and click the logout button
		Thread.sleep(2000);
		driver.close();	//To close the browser
	}
	
}
