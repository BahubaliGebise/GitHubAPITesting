Feature:  Specify a maximum number of results

  # NOte-
  # Even though over portal it shows 9M+records for search 'commits' and same things via API not enabled.
  # API not available - https://api.github.com/search?q=commits&type=commits and getting response as "Not found".
  # Scenario:UC06 - scenario i have implemented with URL:  https://api.github.com/search/repositories?q=repositories
  @API
  Scenario: UC06 - Specify a maximum number of results.

    Given the test case id is "UC06"
    When create a service URL to fetch the maximum number of results from github
    Then perform GET method and verify response along with status code is "200"


