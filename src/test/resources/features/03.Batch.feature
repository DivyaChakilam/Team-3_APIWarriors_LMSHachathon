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
      | Scenario           |
      | invalid Program Id |
      | invalid endpoint   |
      | deleted program id |
      | valid Program Id   |
