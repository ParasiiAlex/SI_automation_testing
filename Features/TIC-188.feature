Feature: TIC-188
  Scenario: Check quick view of a product
    Given I launch Chrome browser2
    And I open loving-hermann page2
    And I scroll down till the section New Arrivals
    When I hover the image of an product from section New Arrival
    Then I check that black button Quick View is displayed
    When I click the button Quick View
    Then I am redirected to another page that presents selected product
    And I check the description section below the product images
    And I close the browser2