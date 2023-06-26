
#1-Provide correct username and correct password validate title
  #2-Provide correct username and wrong password validate errormessage
  #3-Provide wrongusername and correct password validate errormessage
  #4-Provide both empty and validate errorMessage
@regression
Feature: Testing login functionality
@smoke
  Scenario: Happy path login functionality
    When User enters the correct username 'guest1@microworks.com' and password 'Guest1!' and clicks login button
    Then User validates the mainPage 'ORDER DETAILS - Weborder'

  Scenario: negative login w. correct username but wrong password
    When User enters the username 'guest1@microworks.com' and password 'wrongPassword' and clicks login button
    Then User validates the message 'Sign in Failed'
@smoke
  Scenario: negative login w. wrong username but correct password
    When User enters the username 'wrongUserName@gmail.com' and password 'Guest1!' and User clicks login button
    Then User validates the message 'Sign in Failed'

  Scenario: negative login w. both empty username and password
    When User enters the username '' and password '' and User clicks login button
    Then User validates the message 'Sign in Failed'

