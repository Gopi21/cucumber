#Author: your.email@your.domain.com
Feature: Google Search

  Scenario: to very the search results page
    Given The user is in google home page
    When The user search for a text
    Then The user should be in search result page
