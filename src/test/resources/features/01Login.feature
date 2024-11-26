@Team3_API_Warriors_LMS_Rest_Assured_Hackathon
Feature: Login to LMS Portal

  @loginPost
  Scenario Outline: check if user is able to login with invalid data "<scenario>"
    Given Admin creates request with credentials with "<scenario>"
    When Admin calls post method with endpoint
    Then Admin receives status code with status text

    Examples: 
      | scenario             |
      | Invalid Endpoint     |
      | Invalid EmailId      |
      | Invalid Password     |
      | Invalid Method       |
      | Valid Credentials    |
      
      
  
