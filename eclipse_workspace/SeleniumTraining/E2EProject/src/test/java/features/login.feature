#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login to Application
 Scenario Outline: Positive test validating testing
Given Initialize the browser with chrome
And Navigate to "https://rahulshettyacademy.com/"
And Click on login link in home page to land on secure sign in page
When User enters "<Username>" and "<Password>" and log in
Then Verify that user is successfully logged in


Examples: 
	| Username   			| Password |
	|test99@gmail.com | 123456   |
	|test123@gail.com | 123456   |


