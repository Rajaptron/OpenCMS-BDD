Feature: %Free opensourcecms Create Users

Scenario Outline: Free opensourcecms Create a new user scenario

Given user is already on Login Page
When title of login page is Username or Email Address
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then click on users link at left side of website
Then user moves to new user page and click on Add new button
Then user enters new user details "<username>" "<firstname>" and "<lastname>" and "<usersname>" and "role"
Then verify user is created 
Then Close the browser

Examples:

	| username | password | usersname  | email            |  firstname  | lastname | role|
	|  opensourcecms | opensourcecms | Tom 	  | tom@gmail.com    |   tom       | Peter    | Administrator|
	| opensourcecms  | opensourcecms | David 	  | david@gmail.com  |   David     | Dsouza   |	Contributor|