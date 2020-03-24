package com.Crossword.StepDefinition;

import java.io.IOException;

import com.Crossword.ExcelUtility.Crossword_Excel;
import com.Crossword.Pages.UpdateProfile_Crossword_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_UpdateProfile
{
	UpdateProfile_Crossword_Page MyUpdateProfile = new UpdateProfile_Crossword_Page();
	Crossword_Excel data = new Crossword_Excel();
	
	//To Update Profile
		@Given("^The User launch the Chrome application to update$")
		public void the_User_launch_the_Chrome_application_to_update() throws IOException 
		{
			MyUpdateProfile.LaunchBrowser();
		}

		@Then("^The user update the profile details$")
		public void the_user_update_the_profile_details() throws IOException, InterruptedException
		{
			for(int i=5;i<=5;i++)
			{
				MyUpdateProfile.updateProfile(i);
			}
		}

		@Then("^Close the updated browser$")
		public void close_the_updated_browser() throws InterruptedException 
		{
			MyUpdateProfile.close_updateProfile();
		}
	
	
}
