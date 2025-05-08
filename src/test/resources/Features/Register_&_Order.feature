Feature: Registration & Place an order

Scenario: user register a new account and place an order

Given user access homepage and click register
Then user navigate to homepage
When user sroll down and add to cart phone and headphone
When user click cart logo on the right top of the page
Then user click proceed to checkout
When user fill out with personal infor
Then user click PLACE ORDER
