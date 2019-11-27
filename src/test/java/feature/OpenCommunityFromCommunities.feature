Feature: Open community page from communities page

  Background: Login from login page
    Given user is in 'https://www.vk.com/login' page
    When user 'Vladislav' log in to the system from login page
    Then user page is displayed
    And the name of the user is 'Vladislav Scherba'

  Scenario: Open followed community page
    Given user has opened communities page
    When user opens followed community 'Lend Me Your Ears | LMYE' page
    Then community page is displayed
    And the name of the community is 'Lend Me Your Ears | LMYE'

  Scenario: Open community from the search page
    Given user has opened communities page
    When user opens community from the search 'AURORA' page
    Then community page is displayed
    And the name of the community is 'AURORA'