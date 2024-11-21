@login
Feature: Login to LMS Portal

  #@login
  #Scenario Outline: check if user is able to login with valid/invalid data
    #Given Admin creates request with required credentials with <scenario>
    #When Admin calls <Https method> with <endpoint>
    #Then Admin receives <status code>with <status text>
#
    #Examples: 
      #| scenario             | 
      #| Valid Credentials    |   
      #| Invalid Endpoint     |
      #| Invalid Content Type |
      #| Invalid Method       |
      #| Invalid EmailId      |
      #| Invalid Password     |

      
  @login
  Scenario: Check if user can login with valid/invalid data
    Given Admin creates request with required credentials for scenario
    When Admin calls API
    Then Admin validates the response
    