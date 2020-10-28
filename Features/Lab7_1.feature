Feature: Lab7_1

  Scenario: Check google search
    Given I launch chrome browser
    And I open google.com page
    Then I check for google logo
    When I enter a text for search
    Then I check the number of results on a single page
    When I open google.com page
    And I enter nothing and click search button
    Then I see no changes
    When I open google.com page
    And I search for irrelevant keyword
    Then I check for Did you mean link
    And I close the page and browser