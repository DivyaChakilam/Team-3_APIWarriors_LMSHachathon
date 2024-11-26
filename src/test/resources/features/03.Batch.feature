@Batch
Feature: Create new Batch

  Background:
    Given Admin set Authorization for batch
  @postbatch
  Scenario Outline: Check if admin able to create a Batch with valid/invalid details
    Given Admin creates POST Request  with valid data in requestBody for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for batch with statusText
    Examples:
      | Scenario                  |
      | Existing batch Number     |
      | MissingMandatoryField     |
      | Invalid endpoint          |
      | Inactive progId           |
      | Invalid data              |
      | Missing additional fields |
      | Valid details             |
  @putbatch
  Scenario Outline: Check if admin able to update a Batch with valid/invalid details
    Given Admin creates PUT Request  with valid data in requestBody for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for batch with statusText
    Examples:
      | Scenario                                                               |
      | invalid batchID and mandatory fields                                   |
      | valid batchID and missing mandatory fields                             |
      | update a batch with invalid data                                       |
      | update a Batch with invalid enpoint                                    |
      | valid batchID and deleted programID field  with other mandatory fields |
      | update a Batch with a deleted batchID in the endpoint                  |
      | valid batchID and mandatory fields in request body                     |


  @getbatchbyprogramid
  Scenario Outline: Check if admin able to retrieve a batch with valid/invalid Program ID
    Given Admin creates GET Request with valid/invalid Program Id for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for batch with statusText
    Examples:
      | Scenario                  |
      | GetBatchByProgramIdNoAuth |
      | invalid Program Id        |
      | invalid endpoint          |
      | deleted program id        |
      | valid Program Id          |

  @GetBatchByBatchName
  Scenario Outline: Check if admin able to retrieve a batch with valid_invalid Batch Name
    Given Admin creates GET Request with valid_invalid Batch Name for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for batch with statusText
    Examples:
      | Scenario                      |
      | RetrieveBatchNoAuth           |
      | RetrieveBatchValidBatchName   |
      | RetrieveBatchInvalidBatchName |
      | RetrieveBatchInvalidEndpoint  |
      | RetriveDeletedBatchName       |

  @GetBatchByBatchId
  Scenario Outline: Check if admin able to retrieve a batch with valid_invalid Batch ID
    Given Admin creates GET Request with valid_invalid Batch Id for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for batch with statusText
    Examples:
      | Scenario                     |
      | RetrieveBatchByBatchIdNoAuth |
      | RetrieveBatchValidBatchId    |
      | RetriveBatchDeletedBatchId   |
      | RetrieveBatchInvalidBatchId  |
      | RetrieveBatchInvalidEndpoint |

  @deleteBatchByBatchId
  Scenario Outline: Check if admin is able to  delete a Batch with valid/invalid details
    Given Admin creates delete a Batch Request for the LMS with request body "<scenario>"
    When Admin sends HTTPS delete a Batch Request and request Body with "batchId" endpoint
    Then Admin receives StatusCode with statusText for delete a Batch "<Scenario>"

    Examples:
      | scenario                   |
      | DeletebatchvalidbatchId    |
      | DeletebatchInvalidbatchId  |
      | DeleteBatchInvalidEndpoint |
      | DeleteBatchInvalidEndpoint |
      | DeleteBatchInvalidMethod   |
#      | DeleteBatchInvalidNoAuth   |
