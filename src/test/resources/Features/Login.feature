Feature: user registered at site
user want to login with registered account

Background: 
Given user navigate to page
When user click login link
Given user at login page

@login_with_valid_account
Scenario: user sucessfully login with valid account
When user enter valid account and password
And user click login button
Then user should be navigate to homepage after click login button

@login_with_invalid_account
Scenario: user fail to login with invalid account
When user enter invalid account and password
And user click login button
Then user should see a notification for invalid account

@login_with_empty_username
Scenario: user fail to login with empty username field
When user leave username field empty and enter password
And user click login button
Then user should see a notification to remind entering username

@login_with_empty_password
Scenario: user fail to login with empty password field
When user enter username and leave password field empty
And user click login button
Then user should see a notification to remind entering password