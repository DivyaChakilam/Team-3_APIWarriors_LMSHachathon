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
      | Scenario               |
      | InvalidEndpoint        |
      | Existing Program       |
      | Invalid Method         |
      | Missing Values         |
      | NoAuth                 |
      | PostWithoutRequestBody |
      | Invalid Request Body   |
		 #| Mandatory            |
      #| Full Details         |
  @putProgramById
  Scenario Outline: Check if admin is able to update program by programID with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programId" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples: 
      | Scenario                    |
      | PutProgramByInvalidID       |
      | PutInvalidRequestBodyByID   |
      | PutWithoutRequestBodyByID   |
      | PutInvalidMethodByID        |
      | PutValidProgramIdWithNoAuth |
      | PutValidProgramId           |

  @putProgramByName
  Scenario Outline: Check if admin is able to update program by programName with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programName" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples:
      | Scenario                      |
      | PutProgramByInvalidName       |
      | PutMissingMandatoryByName     |
      | PutInvalidValuesByName        |
      | PutInvalidProgramDescByName   |
      | PutValidProgramNameWithNoAuth |
      | PutWithoutRequestBodyByName   |
      | InvalidToken                  |
      | PutValidProgramName           |
      | PutStatusByProgramName        |

  @getProgramById
  Scenario Outline: Check if admin is able to GET program by programID with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programId" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"
    And Admin recives Responce Body for the given programId

    Examples:
      | Scenario                          |
      | GetProgramByInvalidID             |
      | GetProgramByIdWithNoAuth          |
      | GetProgramByIdWithInvalidEndpoint |
      | GetProgramByIdWithInvalidBaseURI  |
      | GetProgramByvalidID               |

  @getAllProgramWithUsers @getAllProgram
  Scenario Outline: Check if admin is able to GetAllProgramUsers/GetAllProgram with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "No" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"
    And Admin recives all programs with users "<Scenario>"

    Examples:
      | Scenario                              |
      | GetAllProgramUsersWithInvalidEndpoint |
      | GetAllProgramUsersWithInvalidMethod   |
      | GetAllProgramUsersWithNoAuth          |
      | GetAllProgramUserWithInvalidBaseURI   |
      | GetAllProgramUsersValid               |
      | GetAllProgramWithInvalidEndpoint      |
      | GetAllProgramWithInvalidMethod        |
      | GetAllProgramWithInvalidBaseURI       |
      | GetAllProgramWithNoAuth               |
      | GetAllProgramValid                    |

  @deleteProgramByName
  Scenario Outline: Check if admin is able to Delete program by programName with valid/invalid details
    Given Admin creates Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with "programName" endpoint
    Then Admin receives StatusCode with statusText "<Scenario>"

    Examples:
      | Scenario                           |
      | DeleteProgramByInvalidName         |
      | DeleteProgramByNameInvalidEndpoint |
      | DeleteProgramByNameInvalidMethod   |
      | DeleteProgramByNameInvalidBaseURI  |
      | DeleteProgramByNameNoAuth          |
      #| DeleteProgramByValidName           |

  @deleteProgramByProgramId
  Scenario Outline: Check if Admin able to delete a program with valid/invalid program ID
    Given Admin creates DELETE Request for the LMS API endpoint with valid_invalid program ID "<Scenario>"
    When Admin sends HTTPS Request with endpoint for delete program
    Then Admin receives StatusCode for program delete with statusText

    Examples:
      | Scenario                         |
      | valid LMS API,invalid program ID |
      | DeleteProgramByProgramIdNoAuth   |
      | valid program ID                 |