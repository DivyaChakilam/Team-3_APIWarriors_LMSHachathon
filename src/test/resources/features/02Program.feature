@program
Feature: Program Post Request
 Background:
Given Admin set Authorization
  @postprogram
  Scenario Outline: Check ic admin is able to create progrma with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with endpoint
    Then Admin receives StatusCode with statusText

    Examples: 
      | Scenario             |
      | Invalid Endpoint     |
      | Existing Program     |
      | Invalid Method       |
      | Missing Values       |
      | Invalid Request Body |
      | Mandatory            |
      | Full Details         |
