Feature:  Fetching the total number of Github repositories for by given language.

  @API
  Scenario: UC01 - Fetching the total number of Github repositories for a given programming language.
    Given the test case id is "UC01"
    When create a service URL to fetch number of repositories for a provided programming language
    Then perform GET method and verify response along with status code is "200"
