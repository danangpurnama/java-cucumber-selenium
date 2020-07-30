Feature: Add Product Cart

  Scenario: Add Multiple product cart
    Given User go to home page bhinneka
    When User try to login
    And User add 3 product
    Then User should see product added