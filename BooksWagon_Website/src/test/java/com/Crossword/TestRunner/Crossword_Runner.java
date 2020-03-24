package com.Crossword.TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/feature/Testcase.feature",
		plugin = {"pretty", "html:reports/cucumber-html-report"},
		tags = {"@TC1_Updating_the_profile_details, @TC2_Adding_new_address, "
				+ "@TC3_Scrolling_Functionality, @TC4_Slider_Functionality, @TC5_To_view_the_details_of_Award_winner"},
		glue = {"com.Crossword.StepDefinition"},
		monochrome = true
		)


public class Crossword_Runner 
{

}
