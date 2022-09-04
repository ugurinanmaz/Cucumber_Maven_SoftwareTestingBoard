Feature: Purchase Functionality Test

  Scenario: Add an Item to the Cart and complete Purchase steps

    Given Navigate to magento Software testing board
    When Enter username and password and click login button
    Then User should login successfully
    And User select an item and complete purchase steps
    Then Validate purchase
