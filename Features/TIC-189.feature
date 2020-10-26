Feature: TIC-189
  Scenario: Check if the user is not able to perform a registration with invalid input data
    Given I launch Chrome browser3
    And I open loving-hermann page3
    When I click the button Sign Up
    Then I check that A pop up form is displayed
    When I Fill the input field Name with valid data
    And I Fill the input field Email with invalid data
    And I Fill the input field Password with valid data
    And I Fill the input field Confirm Password with valid data
    And I Click SIGN UP button
    Then Alert message is displayed under the input field Email
    And I close the browser3