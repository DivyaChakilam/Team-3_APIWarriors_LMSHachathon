
@Classgetrequest
Feature: Class GET Request

  
  @getrequestallclassrecordings
  Scenario Outline: Check if admin able to retrieve all class recording with valid/invalid Endpoints
    Given Admin creates get request (all class recordings)Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all class recordings)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclassrecordings "<Scenario>"

    Examples: 
      | scenario         |
      | GetallclassInvalidEndpoint |
      | GetallclassInvalid Method   |
      | GetallclassValid Endpoint   |
      | GetallclassNoAuth           |
      @GetallClassList
      Scenario Outline: Check if admin able to retrieve all class list with valid/invalid Endpoints
    Given Admin creates get request (all classlist)Request for  the LMS API with  "<scenario>"
    When Admin sends   get request (all class list)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclasslist "<Scenario>"
      Examples: 
      | scenario                          |
      | GetallclasslistInvalid Endpointclass   |
      | GetallclasslistInvalid Methodclass     |
      | GetallclasslistValid Endpointclass     |
      |GetallclasslistNoAuth                   |
      @GetAllClassesByBatchId
 Scenario Outline: Check if admin able to retrieve all Classes  with  Batchid and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid Batchid) Request for  the LMS API with  "<scenario>"
    When Admin sends   get all Classes  HTTPS Request with "batchId" endpoint
    Then Admin receives StatusCode with statusText for all Classes  with valid Batchid "<scenario>"
      Examples: 
      | scenario             |
      | Getallclasswithbatchid     |
      | Getallclasswithinvalidbatchid       |
      | GetallclasswithbatchidInvalid     |
      | GetallclasswithbatchidInvalidmethod|
       |GetallclassbatchidNoAuth |
      
      @GetAllClassesByStaffId
 Scenario Outline: Check if admin able to retrieve all Classes  with  StaffId and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid StaffId) Request for  the LMS API with  "<scenario>"
    When Admin sends   get all Classes  with HTTPS Request with "StaffId" endpoint
    Then Admin receives StatusCode with statusText for all Classes  with StaffId "<scenario>"
      Examples: 
      | scenario             |
      | GetallclasswithStaffId     |
      | GetallclasswithinvalidStaffId       |
      | GetallclasswithStaffIdInvalidEndpoint     |
      | GetallclasswithStaffIdInvalidmethod     | 
      | GetallclassStaffIdNoAuth |
     @GetAllClassesByClassTopic
 Scenario Outline: Check if admin able to retrieve all Classes  with  ClassTopic and valid/invalid Endpoints
    Given Admin creates get request (all Classes  with valid ClassTopic) Request for  the LMS API with  "<scenario>"
    When Admin sends get all class HTTPS Request with "ClassTopic" endpoint
    Then Admin receives StatusCode with statusText for all Classes  with ClassTopic "<scenario>"
      Examples: 
      | scenario             |
      | GetallclasswithClassTopic     |
      | GetallclasswithinvalidClassTopic       |
      | GetallclasswithClassTopicInvalidEndpoint     |
      | GetallclasswithClassTopicInvalidmethod    | 
      |GetallclassClassTopicNoAuth | 
      @UpcomingClassesforparticularstudentId
 Scenario Outline: Check if admin able to retrieve upcoming classes with valid/invalid Student Id  Endpoints
    Given Admin creates get request to retrieve upcoming classes Request for  the LMS API with  "<scenario>"
    When Admin sends   get request to retrieve upcoming classes  with "studentId" endpoint
    Then Admin receives StatusCode with statusText  for retrieve upcoming classesforparticularstudentId "<scenario>"
      Examples: 
      | scenario             |
      | GetallclasswithStudentId     |
      | GetallclasswithnvalidStudentId       |
      | GetallclasswithStudentIdInvalidEndpoint     |
      | GetallclasswithStudentIdInvalidmethod    | 
       |GetallclasswithStudentIdNoAuth |
      
      @downloadClassRecordingsbyClassId
 Scenario Outline: Check if admin able to retrieve downloadClassRecordings by valid/invalid ClassId  Endpoints
    Given Admin creates get request to downloadClassRecordingsbyClassId for  the LMS API with  "<scenario>"
    When Admin sends   get request to downloadClassRecordingsbyClassId  with "ClassId" endpoint
    Then Admin receives StatusCode with statusText  for downloadClassRecordingsbyClassId "<scenario>"
      Examples: 
      | scenario             |
      | GetallclasswithClassId     |
      | GetallclasswithinvalidClassId       |
      | GetallclasswithClassIdinvalidEndpoint     |
      | GetallclasswithClassIdInvalid method     | 
       |  GetallclasswithClassIdNoAuth                                       |
      
      
      
      
      
      