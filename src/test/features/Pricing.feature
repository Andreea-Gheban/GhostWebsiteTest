Feature: Price Page

  Scenario: Check if price can be changed based on audience
    Given The user navigate to the ghost page
    When The user click on "Resources" menu
    And The user click on Start here section
    When The user search for "create new blog"
    When The user open the tenth result
    And The user scroll up to the Price button page
    When I the user click on Price button
    Then The user can see that the Price page opens
    When The user change the audience slider to 20k members
    Then The user can check that price has been updated

