package com.Crossword.StepDefinition;

import java.io.IOException;

import com.Crossword.Pages.Slider_Crossword_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_Slider
{
	Slider_Crossword_Page MySlider = new Slider_Crossword_Page();
	
	//Slider handling the price range
		@Given("^The User launch the Chrome application to slider$")
		public void the_User_launch_the_Chrome_application_to_slider() throws IOException 
		{
		  MySlider.LaunchBrowser();
		}

		@Then("^The user slider the price range$")
		public void the_user_slider_the_price_range() throws InterruptedException 
		{
		   MySlider.slider();
		}

		@Then("^Close the slider browser$")
		public void close_the_slider_browser() throws InterruptedException 
		{
		   MySlider.close_slider();
		}
}
