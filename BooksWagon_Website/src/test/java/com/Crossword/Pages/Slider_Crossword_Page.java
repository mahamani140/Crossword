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
	
	//Slider handling the price range
	public void slider() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(book).click();
		driver.findElement(price).click();
		WebElement Slider = driver.findElement(slider);
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action dragAndDrop = builder.clickAndHold(Slider).moveByOffset(40,0).release().build();
		dragAndDrop.perform(); 
	}
	
	public void close_slider() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
}
