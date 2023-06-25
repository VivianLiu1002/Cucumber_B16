Feature: Testing the Google Search Functionality Parameters
#general description (feature name must be unique)

  Background: repeated search steps
    Given User navigates to 'https://www.google.com/'

  Scenario: Happy Path(positive) testing for search Parameters
    #test case
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path(positive) Testing Result for Search Parameters
#    Given User navigates to 'https://www.google.com/'
    When User searches for 'Kyrgyz Food In USA'
    Then User validates the result is less than 300000000

  Scenario: Testing loading time search for an item Parameters
#    Given User navigates to 'https://www.google.com/'
    When User searches for 'Turkish baklava'
    Then User validates the loading time is less than 1.0
