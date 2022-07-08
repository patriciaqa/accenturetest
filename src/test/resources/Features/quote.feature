#Author: Patricia Neris
#Date: july 06, 2022
#Subject: Technical test



Feature: Quote insurance
  As client
  I want to receive the insurance quote
  To purchase vehicle insurance

@mainway
  Scenario: Quote vehicle insurance
    Given I want to purchase vehicle insurance
    And I enter valid vehicle data
    And I enter valid insurant data
    And I enter valid product data
    And I choose the price
    And I enter the account info
    When I send quote
    Then the system should display the confirmation message "Sending e-mail success!"