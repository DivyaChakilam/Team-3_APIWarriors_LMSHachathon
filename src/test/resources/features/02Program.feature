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

#  @putProgramById
#  Scenario Outline: Check if admin is able to update program by programID with valid/invalid details
#    Given Admin creates Request for the LMS with request body "<Scenario>"
#    When Admin sends HTTPS Request and request Body with "programId" endpoint
#    Then Admin receives StatusCode with statusText "<Scenario>"
#
#    Examples:
#      | Scenario                    |
#      | PutInvalidProgramId         |
#      | PutInvalidRequestBodyByID   |
#      | PutWithoutRequestBodyByID   |
#      | PutInvalidMethodByID        |
#      | PutValidProgramIdWithNoAuth |
#      | PutValidProgramId           |
#
#  @putProgramByName
#  Scenario Outline: Check if admin is able to update program by programID with valid/invalid details
#    Given Admin creates Request for the LMS with request body "<Scenario>"
#    When Admin sends HTTPS Request and request Body with "programName" endpoint
#    Then Admin receives StatusCode with statusText "<Scenario>"
#
#    Examples:
#      | Scenario                      |
#      | PutInvalidProgramName         |
#      | PutMissingMandatoryByName     |
#      | PutInvalidValuesByName        |
#      | PutInvalidProgramDescByName   |
#      | PutValidProgramNameWithNoAuth |
#      | InvalidToken                  |
#      | PutValidProgramName           |
#      | PutStatusByProgramName        |

  @deleteprogram
  Scenario Outline: Check if Admin able to delete a program with valid/invalid program ID
    Given Admin creates DELETE Request for the LMS API endpoint with valid_invalid program ID "<Scenario>"
    When Admin sends HTTPS Request with endpoint for delete program
    Then Admin receives StatusCode for program delete with statusText

    Examples:
      | Scenario                         |
      | valid LMS API,invalid program ID |
      | valid program ID                 |

  @getprogrambyid
  Scenario Outline: check if Admin able to get program with valid_invalid program id
    Given Admin creates GET request for the LMS API endpoint with valid_invalid program id "<Scenario>"
    When Admin sends HTTPS Request with endpoint for get program
    Then Admin receives StatusCode for program delete with statusText
    Examples:
      | Scenario                                   |
      | get program with valid program ID          |
      | get program with invalid program ID        |
      | get program with invalid baseURI           |
      | get program without Authorization - NoAuth |
      | get program with invalid Endpoint          |