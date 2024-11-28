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
      | Scenario                |
      | Invalid Endpoint        |
      | Existing class topic    |
      | Without request body    |
      | Additional field values |
      | Invalid data            |
      | Mandatory               |
      | Valid details           |

  #--------------------------------PUT CLASS-----------------------------
  @putClassRecPath
  Scenario Outline: Check if admin is able to update class recording path by classID with valid/invalid details
    Given Admin creates Class Put Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with put by ClassId endpoint
    Then Admin receives StatusCode with statusText for the Put Class request sent

    Examples: 
      | Scenario                  |
      | PutRecInvalidEndpoint     |
      | PutRecInvalidMethod       |
      | PutRecNoAuth              |
      | PutRecInvalidBearerToken  |
      | PutRecNonExistingClassId  |
      | PutRecAlphanumericClassId |
      | PutRecClassRecAsInteger   |
      | PutRecCsIdasString        |
      | PutRecValidCredentials    |

  @putClassDetails
  Scenario Outline: Check if admin is able to update class details by classID with valid/invalid details
    Given Admin creates Class Update All details Request for the LMS with request body "<Scenario>"
    When Admin sends HTTPS Request and request Body with put by ClassId endpoint
    Then Admin receives StatusCode with statusText for the Put Class Details request sent

    Examples: 
      | Scenario                               |
      | PutClassInvalid Endpoint               |
      | PutClassInvalidMethod                  |
      | PutClassNoAuth                         |
      | PutClassInvalidBearerToken             |
      | PutClassInvalidBearerToken             |
      | PutClassNonExistingClassId             |
      | PutClassAlphanumericClassId            |
      | PutClassWithDeletedClassId             |
      | PutClassWithoutBatchId                 |
      | PutClassWithDeletedBatchId             |
      | PutClassWithNonExistingBatchId         |
      | PutClassWithAlphanumericBatchId        |
      | PutClassWithoutClassTopic              |
      | PutClassWithoutClassDate               |
      | PutClassWithoutClassNo                 |
      | PutClassWithoutClassStaffId            |
      | PutClassWithoutClassStatus             |
      | PutClassWithInvalidBatchId             |
      | PutClassWithInvalidClassTopic          |
      | PutClassWithInvalidClassDate           |
      | PutClassWithInvalidClassNo             |
      | PutClassWithInvalidClassStaffId        |
      | PutClassWithInvalidClassStatus         |
      | PutClassWithClassDescAsInteger         |
      | PutClassWithClassCommentsAsInteger     |
      | PutClassWithClassNotesAsInteger        |
      | PutClassWithClassRecPathAsInteger      |
      | PutClassWithoutClassScheduledDates     |
      | PutClassWithInvalidClassScheduledDates |
