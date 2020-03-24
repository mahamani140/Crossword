package com.Crossword.StepDefinition;

import java.io.IOException;

import com.Crossword.Pages.NewAddress_Crossword_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_NewAddress 
{
	NewAddress_Crossword_Page MyNewAddress = new NewAddress_Crossword_Page();
	
	//To Add new address
		@Given("^The User launch the Chrome application to add address$")
		public void the_User_launch_the_Chrome_application_to_add_address() throws IOException 
		{
			MyNewAddress.LaunchBrowser();
		}

		@Then("^The user add the new address$")
		public void the_user_add_the_new_address() throws InterruptedException 
		{
			Thread.sleep(4000);
			MyNewAddress.newAddress();
		}

		@Then("^Close the added address browser$")
		public void close_the_added_address_browser() throws InterruptedException 
		{
			MyNewAddress.close_address();
		}
}
