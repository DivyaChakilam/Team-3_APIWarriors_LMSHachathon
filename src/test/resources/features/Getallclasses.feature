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
Given Admin set Authorization
  @getrequestallclassrecordings
  Scenario Outline: Check if admin able to retrieve all class recording with valid/invalid Endpoints
    Given Admin creates get request (all class recordings)Request for  the LMS API with  "<scenario>""
    When Admin sends   get request (all class recordings)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclassrecordings

    Examples: 
      | Scenario             |
      | Invalid Endpoint     |
      | Invalid Method       |
      | Valid Endpoint       |
      
      @GetallClassList
      Scenario Outline: Check if admin able to retrieve all class list with valid/invalid Endpoints
    Given Admin creates get request (all classlist)Request for  the LMS API with  "<scenario>""
    When Admin sends   get request (all class list)HTTPS Request with endpoint
    Then Admin receives StatusCode with statusText for getallclasslist
      Examples: 
      | Scenario             |
      | Invalid Endpoint     |
      | Invalid Method       |
      | Valid Endpoint       |
      