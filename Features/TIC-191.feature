Feature: TIC-191
  Scenario: Check if the user is able to execute login
    Given I launch Chrome browser5
    And I open loving-hermann page5
    When I Click the button Sign In
    Then I check that A pop up form is displayed3
    When I Fill the input field Name with valid data3
    And I Fill the input field Password with valid data3
    And I Click SIGN IN button
    Then I am redirected to home page2
    When I am looking for Sign In Button2
    Then Sign In button is not present2
    And Profile button is displayed
    And I close the browser5