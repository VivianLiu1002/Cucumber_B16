Feature: Testing the Google Search Functionality
  Scenario: Happy Path(positive) testing for search
    Given User navigates to Google
    When User searches for CodeFish
    Then User validates first page returns more than ten links
