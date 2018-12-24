#Author: your.email@your.domain.com
Feature: to test Add customer feature

  @tag1
  Scenario: to verify the customer ID with valid customer details
    Given The user is in guru telecome home page
    And The customer navigates to add customer page
    When the user enter the customer details and clicks the submit button
      | backround | fname     | lname     | email                 | addr    | telephoneno |
      | Done      | testfname | testlname | gopigrtyuio@gmail.com | address |  8122631285 |
      | Done      | email     | gopi      | gopigrtyuio@gmail.com | address |  8122631285 |
      | Done      | testfname | testlname | gopigrtyuio@gmail.com | address |  8122631285 |
      | Done      | testfname | testlname | gopigrtyuio@gmail.com | address |  8122631285 |
    And The user navigates to home page and cliks on Add Tariff Plan to Customer
    Then The user should see a customer id generated
