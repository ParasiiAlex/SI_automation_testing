Feature: TIC-193
  Scenario: Check if the user can add multiple products to cart
    Given I launch Chrome browser7
    And I open loving-hermann page7
    When I Scroll down till New Arrival section
    Then I check that New Arrival section exists
    When I Click ADD TO CART button
    Then I check that In the cart list has appeared selected product
    When I Modify the quantity of the second product from the cart from 1 to 10
    Then I check that The Price of the product is raised
    And I close the browser7