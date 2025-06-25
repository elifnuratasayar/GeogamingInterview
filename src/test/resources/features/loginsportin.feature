Feature:Invalid Login Functionality

  Background: The user already home page
@invalidlogin
  Scenario Outline:Verify error message  display
    Given The user able to click Login button
    Then The user able to fill out "<username>"
    Then The user able to fill out "<password>" and click  login button
    And Verify the user should see "<error>"
    Examples:
      | username | password  | error                                                    |
      | testuser | wrongpass | Incorrect username or password entered. Please try again |
