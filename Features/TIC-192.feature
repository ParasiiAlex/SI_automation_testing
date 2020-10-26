Feature: TIC-192
  Scenario: Check if the user can submit the contact form
    Given I launch Chrome browser6
    And I open loving-hermann page6
    When Click on the tab Contact
    Then I check that A contact form is present
    When I Fill the input field Name with valid data4
    And I Fill the input field Email with valid data4
    And I Fill the input field Subject with a valid data
    And I Fill the input field Message with a valid data
    And I Click SEBD button
    Then I check for A notification on the top of webpage
    And I close the browser6