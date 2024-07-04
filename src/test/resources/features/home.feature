Feature: Login

  @HomeTest
  Scenario: Verify successful login
    Given User on login screen
    When User enter login credentials
    And User click on submit button
    Then User verify products page displayed


  @HT2 @HomeTest
  Scenario Outline: Verify successful login with outline
    Given User on login screen
    When User enter login credentials "<username>" and "<password>"
    And User click on submit button
    Then User verify products page displayed
    Examples:
      | username     | password     |
      | StandardUser | secret_sauce |

  @HT3 @HomeTest
  Scenario: Verify successful login with single row
    Given User on login screen
    When User enter login data
      | StandardUser | secret_sauce |
    And User click on submit button
    Then User verify products page displayed

  @HT4 @HomeTest
  Scenario: Verify successful login with row header
    Given User on login screen
    When User enter login data with row header
      | username     | password     |
      | StandardUser | secret_sauce |
    And User click on submit button
    Then User verify products page displayed