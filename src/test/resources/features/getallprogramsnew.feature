@GetAllprograms
Feature: Get request for All Programs

  @GetRequest_AllPrograms
  Scenario Outline: Check if Admin is able to retrieve all programs with various endpoints and methods
    Given Admin creates GET all program request for the LMS API with  "<scenario>""
    When Admin sends HTTPS request with endpoint "<endpoint>" 
    Then Admin receives "<statusCode>" status with response body 

  Examples: 
      | scenario            |   
      | Invalid Endpoint    |
      | Invalid Method     |
      | valid Endpoint     |
     @GetRequest_AllPrograms_With_Admins 
     Scenario Outline: Check if Admin is able to retrieve all programswithadmins with various endpoints and methods
    Given Admin creates GET all programadmins request for the LMS API with  "<scenario>""
    When Admin sends HTTPS getallprogramadmins request with endpoint "<endpoint>" 
    Then Admin receives "<statusCode>" status with response body for getallprogramadmins
    Examples: 
      | scenario            |   
      | Invalid Endpoint    |
      | Invalid Method     |
      | valid Endpoint     |