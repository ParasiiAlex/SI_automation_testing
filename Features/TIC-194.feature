Feature: TIC-194
  Scenario: Check if sorting of products works
    Given I launch Chrome browser8
    And I open loving-hermann page8
    When I Click on the Men's wear button
    Then I check that A pop-up should appear with two links
    When I Click on the Clothing link
    Then I check that User should be redirected to page mens.html
    When I Select sorting method Name AZ
    Then I check that Products should be ordered by name fromA to Z
    When I Select sorting method Name ZA
    Then I check that Products should be ordered by name fromZ to A
    And I close the browser8