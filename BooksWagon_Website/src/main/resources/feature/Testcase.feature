@Crossword_WebPage_MAHALAKSHMI
Feature: Crossword Website

@TC1_Updating_the_profile_details
Scenario: To check if the user is able to update the details
Given The User launch the Chrome application to update
Then The user update the profile details
And Close the updated browser

@TC2_Adding_new_address
Scenario: To check if the user is able to add the new address
Given The User launch the Chrome application to add address
Then The user add the new address
And Close the added address browser

@TC3_Scrolling_Functionality
Scenario: To check if the user is able to scroll the page
Given The User launch the Chrome application to scroll down
Then The user scroll the page
And Close the scroll browser

@TC4_Slider_Functionality
Scenario: To check if the user is able to slider the price range
Given The User launch the Chrome application to slider
Then The user slider the price range
And Close the slider browser

@TC5_To_view_the_details_of_Award_winner
Scenario: To check if the user is able to 
Given The User launch the Chrome application to see award
Then The user view the award details
Then Close browser