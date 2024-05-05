Feature:
  As a user
  I want to be able to login to application
  So that I can verify products page

  @Login @DirectData
  Scenario: Verify successful login
    Given User on login page
    When User enter "performance_glitch_user" and "secret_sauce"
    And User click on submit
    Then User verify products page

  @Login @DataTable
  Scenario: Verify visual successful login
    Given User on login page
    When User enter credentials in the input fields
      | visual_user | secret_sauce |
    And User click on submit
    Then User verify products page

  @Login @DataTableWithHeader
  Scenario: Verify problem user successful login
    Given User on login page
    When User enter credentials
      | username     | password     |
      | problem_user | secret_sauce |
    And User click on submit
    Then User verify products page

  @Login @Examples
  Scenario Outline: Verify error user unsuccessful login
    Given User on login page
    When User enter "<username>" and "<password>"
    And User click on submit
    Then User verify products page
    Examples:
      | username                | password     |
      | error_user              | secret_sauce |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | visual_user             | secret_sauce |




