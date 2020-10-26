Feature: TIC-187

  Scenario: Check if user is able to perform a search by product name
    Given I launch Chrome browser
    And I open loving-hermann page
    When I click on the input intended for searching products
    And Fill the input with a real product name
    Then I check the input is containing entered text
    When I click on the Search button
    Then I am redirected to a page containing a list of products
    And I close the browser