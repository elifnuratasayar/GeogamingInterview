@US01
Feature: Homepage Access and Content Verification

  Background: Given the user is on the homepage
    Then The user click alerts

  @Tc01
  Scenario: Verify that the homepage is accessible via direct URL
    Given the user opens a supported web browser
    When the user navigates to "https://en.sportingbull.com/"
    Then the homepage should load successfully without any errors

  @Tc02
  Scenario: Verify the homepage title
    Then the page title should contain "Sportingbull"

  @Tc03
  Scenario: Verify the homepage URL
    Then the current URL should contain "sportingbull.com"

  @Tc04
  Scenario Outline: Verify that "<module>" module is visible on the homepage
    Then the "<module>" module should be visible

    Examples:
      | module     |
      | Top Events |
      | Top Bets   |

  @Tc05
  Scenario Outline: Verify navigation links work on homepage modules
    When the user clicks on the "<section>" section
    Then the user should be redirected to the "<destination>" page

    Examples:
      | section    | destination |
      | Casino     | Casino      |
      | Promotions | Promotions  |
