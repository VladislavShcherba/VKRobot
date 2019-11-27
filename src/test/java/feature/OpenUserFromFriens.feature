Feature: Open user page from friends page

  Background: Login from login page
    Given user is in 'https://www.vk.com/login' page
    When user 'Vladislav' log in to the system from login page
    Then user page is displayed
    And the name of the user is 'Vladislav Scherba'

  Scenario: Open my friend page
    Given user has opened friends page
    When user opens his friend 'Valik Kharlanov' page
    Then user page is displayed
    And the name of the user is 'Valik Kharlanov'

  Scenario: Open user from the search page
    Given user has opened friends page
    When user opens user from the search 'Vladislava Leontyeva' page
    Then user page is displayed
    And the name of the user is 'Vladislava Leontyeva'