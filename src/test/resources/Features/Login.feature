Feature: user registered at site
user want to login with registered account

Background: 
Given user navigate to page
When user click login link

@login_with_valid_account
Scenario: user sucessfully login with valid account
Given user at login page
When user enter valid account and password
And user click login button
Then user should be navigate to homepage

@login_with_invalid_account
Scenario: user fail to login with invalid account
Given user at login page
When user enter invalid account and password
And user click login button
Then user should see a notification for invalid account

@login_with_empty_username
Scenario: user fail to login with empty username field
Given user at login page
When user leave username field empty and enter password
And user click login button
Then user should see a notification to remind entering field