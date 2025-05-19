Feature: user visit page and register 

Scenario Outline: user register a new account 

Given user navigate to page
When user click register link
Then user at register page
When user enter "<name>", "<email>", "<password>" and "<confirm_password>"
When user click register button
Then user should be navigate to homepage

Examples: 
|		name	|				email		   |		password	 |confirm_password|
|121$424#1|2312124					 |123321123			 |123321123      |
|sdfdvxSD|1241!4@gmail.com	 |1241241SDSD		 |1241241SDSD    |
|asdCX@|12412224@gmail.com|123321123Q		 |123321123Q     |
|CZXC23cvcv|12412@gmail.com	 |zxczxczxczxczxc|zxczxczxczxczxc|
|||||
