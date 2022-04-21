Feature:  Fetch repositories for a specific user.

  @API
  Scenario: UC04 - Fetch the github repositories for a specific user.
    Given the test case id is "UC04"
    When create a service URL to fetch number of repositories for specific user
    Then perform GET method and verify response along with status code is "200"
