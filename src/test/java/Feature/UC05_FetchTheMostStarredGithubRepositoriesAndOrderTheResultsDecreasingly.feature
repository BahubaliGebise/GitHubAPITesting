Feature:  Get the most starred Github repositories and order the results decreasingly.

  @API
  Scenario: UC05 - Fetch the most starred Github repositories and order the results decreasingly.
    Given the test case id is "UC05"
    When create a service URL to fetch the most starred repositories and order results desc
    Then perform GET method and verify response along with status code is "200"
