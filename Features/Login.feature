Feature: validate orangeHRM login scenarios
  Scenario: validate positive login credentials
    Given I am on the OrangeHRM login page
    When I entered valid username and password
    And I click on login button
    Then OrangeHRM homepage open

