@SearchPet
Feature: Search a pet by different filters

  Scenario Outline: Search for a pet by id SUCCESSFULLY
    Given I set base URL for search request to the petstore
    And   I set endpoint for  searching "/pet/<id>"
    And   I set header for  request "accept" to value "application/json"
    And   And  I set operation for searching request to "GET"
    When  I search for the pet id
    Then  the status code of search request should be a 200
    And   I should get the pet with the id "<id>"

    Examples:
      | id |
      | 1845563262948980307  |
      | 1845563262948980308  |

  Scenario Outline: Search for a pet by id UNSUCCESSFULLY, a pet id that doesn't exits in data base, throw a 404 error (not found)
    Given I set base URL for search request to the petstore
    And   I set endpoint for  searching "/pet/<id>"
    And   I set header for  request "accept" to value "application/json"
    And   And  I set operation for searching request to "GET"
    When  I search for the pet id
    Then  the status code of search request should be a 404


    Examples:
      | id |
      | -7 |
      | -20 |

  Scenario Outline: Search for many pets by different status SUCCESSFULLY (available,pending, sold)
    Given I set base URL for search request to the petstore
    And   I set endpoint for  searching "/pet/findByStatus?status=<status>"
    And   I set header for  request "accept" to value "application/json"
    And   And  I set operation for searching request to "GET"
    When  I search for pets with the corresponding status "<status>"
    Then  the status code of search request should be a 200

    Examples:
      | status    |
      | available |
      |  sold     |
      |  pending    |

  Scenario Outline: Search for pets by different status that don't exist
    Given I set base URL for search request to the petstore
    And   I set endpoint for  searching "/pet/findByStatus?status=<status>"
    And   I set header for  request "accept" to value "application/json"
    And   And  I set operation for searching request to "GET"
    When  I search for pets with the corresponding status "<status>"
    Then  the status code of search request should be a 200

    Examples:
      | status    |
      | blablabla |
      |  abcdefg  |
      |  zxcvbnm  |