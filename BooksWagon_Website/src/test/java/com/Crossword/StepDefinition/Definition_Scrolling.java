package com.Crossword.StepDefinition;

import java.io.IOException;

import com.Crossword.Pages.Scrolling_Crossword_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_Scrolling
{
	Scrolling_Crossword_Page MyScrolling = new Scrolling_Crossword_Page();

	
	//Scrolling the payment option page
		@Given("^The User launch the Chrome application to scroll down$")
		public void the_User_launch_the_Chrome_application_to_scroll_down() throws IOException 
		{
			MyScrolling.LaunchBrowser();
		}

		@Then("^The user scroll the page$")
		public void the_user_scroll_the_page() throws InterruptedException
		{
			MyScrolling.scroll();
		}

		@Then("^Close the scroll browser$")
		public void close_the_scroll_browser() throws InterruptedException 
		{
			MyScrolling.close_scroll();
		}
}
