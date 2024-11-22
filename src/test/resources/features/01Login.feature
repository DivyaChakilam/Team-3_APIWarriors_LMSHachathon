@login
Feature: Login to LMS Portal

  @invalidlogin
  Scenario Outline: check if user is able to login with invalid data
    Given Admin creates request with credentials with "<scenario>"
    When Admin calls post method with endpoint
    Then Admin receives status code with status text

    Examples: 
      | scenario         |
      | Invalid Endpoint |
      | Invalid EmailId  |
      | Invalid Password |

  @validlogin
  Scenario Outline: check if user is able to login with invalid data
    Given Admin creates request with credentials with "<scenario>"
    When Admin calls post method with endpoint
    Then Admin receives status code with status text

    Examples: 
      | scenario          |
      | Valid Credentials |
