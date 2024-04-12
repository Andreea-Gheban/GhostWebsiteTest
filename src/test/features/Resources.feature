@regression @resources
Feature: Resources Page

  Scenario: Check if complete guide for new blog opens
    Given The user navigate to the ghost page
    When The user click on "Resources" menu
    And The user click on Start here section
    Then The can see that page with guides opens
    When The user search for "create new blog"
    And The user open the tenth result
    Then The user can check that content is loaded

