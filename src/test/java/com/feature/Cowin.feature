Feature: Cowin Application

Scenario: Home Page
Given user Launch The Application
When user Select The State District And Click Search
And user Select The Age Dose Paid And Dosetype
And user Validate The Entered Data With Result
Then close The Application Url
