#Author: your.email@your.domain.com

Feature: to test Add customer feature

  @tag1
  Scenario: to verify the customer ID with valid customer details
    Given The user is in guru telecome home page
    And The customer navigates to add customer page
    When the user enter the customer details
     | Done  | testfname | testlname | gopigrtyuio@gmail.com | address | 8122631285 |
    And The user clicks the submit button
    Then The user should see a customer id generated