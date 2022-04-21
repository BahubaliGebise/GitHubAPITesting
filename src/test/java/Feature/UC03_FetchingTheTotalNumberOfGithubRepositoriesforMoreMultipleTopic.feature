Feature:  Get the total number of Github repo for a given multiple programming language.

  @API
  Scenario: UC03 - Fetching the total number of Github repositories for a given multiple programming language.
    Given the test case id is "UC03"
    When create a service URL to fetch number of repo for a provided more than one programming language
    Then perform GET method and verify response along with status code is "200"
