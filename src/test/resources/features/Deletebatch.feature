@deletebatchrequest
Feature: Batch Delete Request
 Background:
Given Admin set Authorization for batch delete
  @deletebatch
  Scenario Outline: Check if admin is able to  delete a Batch  with valid/invalid details
    Given Admin creates delete a Batch Request for the LMS with request body "<scenario>"
    When Admin sends HTTPS delete a Batch Request and request Body with "batchId" endpoint
    Then Admin receives StatusCode with statusText for delete a Batch "<Scenario>"

    Examples: 
      | scenario           |
      | DeletebatchvalidbatchId   |
      | DeletebatchInvalidbatchId     |
      | DeleteBatchInvalidEndpoint  |
      | DeleteBatchInvalidEndpoint  |
      | DeleteBatchInvalidMethod  |
      | DeleteBatchInvalidNoauth  |