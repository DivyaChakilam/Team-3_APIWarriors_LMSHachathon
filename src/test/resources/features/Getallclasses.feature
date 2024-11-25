#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Classgetrequest
Feature: Class GET Request

  Background: 
    Given  Admin set Authorization

  @getrequestallclassrecordings
  Scenario Outline: Check if admin able to retrieve all class recording with valid/invalid Endpoints
    Given Admin creates get request (all class recordings)Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all class recordings)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclassrecordings

    Examples: 
      | scenario         |
      | Invalid Endpoint |
      | Invalid Method   |
      | Valid Endpoint   |
      
@GetallClassList
      Scenario Outline: Check if admin able to retrieve all class list with valid/invalid Endpoints
    Given Admin creates get request (all classlist)Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all class list)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclasslist
      Examples: 
      | scenario             |
      | Invalid Endpointclass   |
      | Invalid Methodclass     |
      | Valid Endpointclass     |
      @GetAllClassesByBatchId
 Scenario Outline: Check if admin able to retrieve all Classes  with  Batchid and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid Batchid) Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all Classes  with valid Batchid)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for all Classes  with valid Batchid
      Examples: 
      | scenario             |
      | valid Endpointallclasswithbatchid     |
      | valid Endpointallclasswithinvalidbatchid       |
      | Invalid Endpointallclasswithbatchid     |
      | Invalid methodclasswithbatchid     |
@GetAllClassesByStaffId
 Scenario Outline: Check if admin able to retrieve all Classes  with  StaffId and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid StaffId) Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all Classes  with valid StaffId)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for all Classes  with StaffId
      Examples: 
      | scenario             |
      | valid EndpointallclasswithStaffId     |
      | valid EndpointallclasswithinvalidStaffId       |
      | Invalid EndpointallclasswithStaffId     |
      | Invalid methodclasswithStaffId     | 
      
  @GetAllClassesByClassTopic
 Scenario Outline: Check if admin able to retrieve all Classes  with  ClassTopic and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid ClassTopic) Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all Classes  with valid ClassTopic)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for all Classes  with ClassTopic
      Examples: 
      | scenario             |
      | valid EndpointallclasswithClassTopic     |
      | valid EndpointallclasswithinvalidClassTopic       |
      | Invalid EndpointallclasswithClassTopic     |
      | Invalid methodclasswithClassTopic     | 
      
   @UpcomingClassesforparticularstudentId
 Scenario Outline: Check if admin able to retrieve upcoming classes with valid/invalid Student Id  Endpoints
    Given Admin creates get request to retrieve upcoming classes Request for  the LMS API with  "<scenario>"
    When Admin sends   get request to retrieve upcoming classes  with endpoint
    Then Admin receives StatusCode with statusText  for retrieve upcoming classesforparticularstudentId
      Examples: 
      | scenario             |
      | valid EndpointwithStudentId     |
      | valid EndpointinvalidStudentId       |
      | Invalid EndpointStudentId     |
      | Invalid methodStudentId     |  
      
      @downloadClassRecordingsbyClassId
 Scenario Outline: Check if admin able to retrieve downloadClassRecordings by valid/invalid ClassId  Endpoints
    Given Admin creates get request to downloadClassRecordingsbyClassId for  the LMS API with  "<scenario>"
    When Admin sends   get request to downloadClassRecordingsbyClassId  with endpoint
    Then Admin receives StatusCode with statusText  for downloadClassRecordingsbyClassId
      Examples: 
      | scenario             |
      | valid EndpointClassId     |
      | valid EndpointinvalidClassId       |
      | Invalid EndpointClassId     |
      | Invalid methodrecordClassId     |  