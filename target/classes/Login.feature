@SmokeTest
Feature: Login function Test
@TC_01
Scenario: As a Luma application user, must do successful login with valid credential.
Given open any browser
And go to application URL
When Click signin button
And put email
And put password
And Click second signin button
Then Validate login was successful
