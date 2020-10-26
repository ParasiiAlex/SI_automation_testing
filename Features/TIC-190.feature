Feature: TIC-190
  Scenario: Check if the user is able to perform a registration with valid input data
    Given I launch Chrome browser4
    And I open loving-hermann page4
    When I click the button Sign Up2
    Then I check that A pop up form is displayed2
    When I Fill the input field Name with valid data2
    And I Fill the input field Email with valid data
    And I Fill the input field Password with valid data2
    And I Fill the input field Confirm Password with valid data2
    And I Click SIGN UP button2
    Then I am redirected to home page
    When I am looking for Sign In Button
    Then Sign In button is not present
    And I close the browser4