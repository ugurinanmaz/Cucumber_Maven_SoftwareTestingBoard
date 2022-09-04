Feature: Add a New Address Functionality

  Scenario Outline: Add New Address Functionality Test
    Given Navigate to magento Software testing board
    When Enter username and password and click login button
    Then User click to My Account page and then click on Manage Addresses
    And User add a new address with "<firstName>", "<lastName>", "<streetAddress>", "<phone>", "<city>", "<zipcode>"
    Then Validate saved Address
    Examples:
      | firstName | lastName | streetAddress             | phone     | city      | zipcode |
      | Alex      | De Souza | AlexDeSouza St, suit 1907 | 789987879 | Kastamonu | 11414   |
      | Roberto   | Carlos   | Roberto St, suit 100      | 46521345  | Corum     | 22454   |
      | Pascal    | Nouma    | Pascal St, suit 1903      | 19031903  | Besiktas  | 34343  |