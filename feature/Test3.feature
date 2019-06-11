Feature: Free opensourcecms Create Pages

Scenario Outline: Free opensourcecms Create a new page scenario

Given user is already on Login Page
When title of login page is Username or Email Address
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then click on page link at left side of website
Then user moves to create page and enter your page name in text area 
Then click on publish
Then confirm on publish
Then verify your new create page with user name
Then Close the browser

Examples:
| | || | |
| || || |