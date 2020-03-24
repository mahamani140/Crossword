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
	
	//Scrolling the payment option page
	public void scroll() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    
	    Thread.sleep(1000);
	    driver.findElement(payment).click();
	    
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    
	    driver.findElement(takeMe).click();  
	}
	
	
	public void close_scroll() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();
	}
}
