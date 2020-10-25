Feature: Aliexpress Search
  Scenario: Header presence after search
    Given I launch Chrome browser and open aliexpress.com page
    When I make a search for computer
    Then I check the header of page
    And I close the browser