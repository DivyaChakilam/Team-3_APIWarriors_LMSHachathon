@class
Feature: Class Post Request
 Background:
Given Admin set Class Authorization
  @postclass
  Scenario Outline: Check if admin is able to create class with valid/invalid details
    Given Admin creates Class Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Class Request and request Body with endpoint
    Then Admin receives StatusCode with statusText in class module

    Examples: 
    	| Scenario             		|
      | Invalid Endpoint     		|
      | Existing class topic   	|
      | Additional field values |
      | Invalid data						|
      | Mandatory           		|
      | Valid details						|
      

      @getClassByID
  Scenario Outline: Check if admin able to retrieve a batch with valid/invalid Program ID
    Given Admin creates GET Request with valid/invalid Class Id for "<Scenario>"
    When Admin sends HTTPS Request with endpoint
    Then Admin receives StatusCode for Class with statusText

    Examples:
      | Scenario                          |
      | GetClassRecordingByClassID        |
      #| GetClassDetailsByClassID         |
      #| GetClassRecordingByBatchID |
      
      
      
      