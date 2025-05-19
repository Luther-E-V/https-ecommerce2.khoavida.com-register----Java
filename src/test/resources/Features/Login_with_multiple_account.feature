Feature: user login with multiple account

Scenario Outline: user login with multiple account
Given user navigate to page
When user click login link
Then user at login page
When user enter "<accountname>" and "<password>"
And user click login button
Then user should be navigate to homepage after click login button

Examples:
|accountname				|		password		|	
|duczo1111@gmail.com|		123312123		|
|abcdef@gmail.com		|		123321123		|	
|123321123@gmail.com|		123321123		|	
|xczxcs							|		12321313 		|