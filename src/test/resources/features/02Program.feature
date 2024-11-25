@program
Feature: Program Post Request

  Background: 
    Given Admin set Authorization

  @postProgram
  Scenario Outline: Check if admin is able to create program with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples: 
      | Scenario             |
      | Invalid Endpoint     |
      | Existing Program     |
      | Invalid Method       |
      | Missing Values       |
      | NoAuth               |
      | Invalid Request Body |
      | Mandatory            |
      | Full Details         |

  @putProgramById
  Scenario Outline: Check if admin is able to update program by programID with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programId" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples: 
      | Scenario                    |
      | PutInvalidProgramId         |
      | PutInvalidRequestBodyByID   |
      | PutWithoutRequestBodyByID   |
      | PutInvalidMethodByID        |
      | PutValidProgramIdWithNoAuth |
      | PutValidProgramId           |

  @putProgramByName
  Scenario Outline: Check if admin is able to update program by programID with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programName" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples: 
      | Scenario                      |
      | PutInvalidProgramName         |
      | PutMissingMandatoryByName     |
      | PutInvalidValuesByName        |
      | PutInvalidProgramDescByName   |
      | PutValidProgramNameWithNoAuth |
      | InvalidToken                  |
      | PutValidProgramName           |
      | PutStatusByProgramName        |
