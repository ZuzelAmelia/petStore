@AddNewPet
Feature: Add a new pet
  In order to sell a pet
  As a store owner
  I want to add a new pet to the catalog

  Scenario Outline: Add a new pet into the store SUCCESSFULLY
    Given I set base URL for the request to the petstore
    And   I set endpoint to "/pet"
    And   I set header "accept" to value "application/json"
    And   I set header "Content-Type" to value "application/json"
    And   I set body with this information:
    """
    {
      "id": 0,
      "category": {
        "id": 0,
        "name": "string"
      },
      "name": "<valueOfName>",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "string"
        }
      ],
      "status": "<valueOfStatus>"
    }
    """
    And  I set operation request to "POST"
    When I execute the request
    Then the status code should be a 200
    And  the response json path "id" should be a valid id
    And  the response json path "name" should be "<valueOfName>"
    And  the pet should be available in the store

    Examples:
      | valueOfName | valueOfStatus |
      | Pitufo      | pending       |
      | Pluto       | available     |
      | Vera        | sold          |
      |             | pending       |
      |             | 00            |
      |             | 989000000000000000000000000            |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula orci massa, eget pulvinar lacus euismod eu. Nam orci tortor, accumsan sit amet semper semper, commodo vitae risus. Etiam nec turpis vitae sapien ultrices malesuada. Aliquam ullamcorper, tellus at mollis elementum, augue tortor porta lorem, in gravida quam nunc vitae lectus. Maecenas finibus vestibulum orci, vitae sodales nibh. Vestibulum a sagittis massa, vel efficitur erat. Nam vel facilisis risus. Aliquam ut quam non turpis luctus condimentum. Curabitur cursus nulla in scelerisque volutpat.       | sold          |



  Scenario Outline: Try adding a pet with a String as petId, this should throw a 400 error (bad request, the request cannot be fulfilled due to bad syntax)
    Given I set base URL for the request to the petstore
    And   I set endpoint to "/pet"
    And   I set header "accept" to value "application/json"
    And   I set header "Content-Type" to value "application/json"
    And   I set body with this information:
    """
    {
      "id": <valueOfId>,
      "category": {
        "id": 0,
        "name": "string"
      },
      "name": "<valueOfName>",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "string"
        }
      ],
      "status": "<valueOfStatus>"
    }
    """
    And  I set operation request to "POST"
    When I execute the request
    Then the status code should be a 400

    Examples:
      |valueOfId | valueOfName | valueOfStatus |
      | abc       | Molly       | pending       |
      | def       | Molly       | pending       |
