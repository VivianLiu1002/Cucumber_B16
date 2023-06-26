
@apiregression @regression
Feature: Testing the Google Search Functionality
#general description
  Scenario: Happy Path(positive) testing for search
    #test case
    Given User navigates to Google
    When User searches for CodeFish
    Then User validates first page returns more than ten links

    @smoke
    Scenario: Happy Path(positive) Testing Result for Search
      Given User navigates to Google
      When User searches for Kyrgyz Food In USA
      Then User validates the result is less than three hundred millions

      Scenario: Testing loading time search for an item
        Given User navigates to Google
        When User searches for Turkish baklava
        Then User validates the loading time is less than one second
