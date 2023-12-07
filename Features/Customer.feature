Feature: Customers

  Background: below are the common steps for each scenarios
    Given User launch chrome browser
    When User opens urls "https://admin-demo.nopcommerce.com/login"
    When I entered valid username as "admin@yourstore.com" and password as  "admin"
    And I click on login button
    Then User can view Dashboad

  Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close the browser

  Scenario: Search Customer by EmailID
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the serach table
    And close the browser

  Scenario: Search Customer by Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found name in the serach table
    And close the browser
