Feature: Login

  Scenario: Login from login page
    Given user is in 'https://www.vk.com/login' page
    When user 'Vladislav' log in to the system from login page
    Then user page is displayed

  Scenario: Login from index page
    Given user is in 'https://www.vk.com/' page
    When user 'Vladislav' log in to the system from index page
    When user opens his profile
    Then user page is displayed
