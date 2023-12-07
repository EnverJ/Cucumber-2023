Feature: validate adminAreaDmo login
  Scenario: validate positive login credentials
    Given User launch chrome browser
    When User opens urls "https://admin-demo.nopcommerce.com/login"
    When I entered valid username as "admin@yourstore.com" and password as  "admin"
    And I click on login button
    Then adminAreaDmo Title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then page title should be "Your store. Login"
    And close the browser



  Scenario Outline: login Data Driven
    Given User launch chrome browser
    When User opens urls "https://admin-demo.nopcommerce.com/login"
    When I entered valid username as "<email>" and password as  "<password>"
    And I click on login button
    Then adminAreaDmo Title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then page title should be "Your store. Login"
    And close the browser

    Examples:
        |email|password|
        |admin@yourstore.com |admin|
        |admin1@yourstore.com|admin123|

