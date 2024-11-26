#@Batch
#Feature: Create new Batch
#
#  Background:
#    Given Admin set Authorization for batch
#
#  Scenario Outline: Check if admin able to create a Batch with valid/invalid details
#    Given Admin creates POST Request  with valid data in requestBody for "<Scenario>"
#    When Admin sends HTTPS Request with endpoint
#    Then Admin receives StatusCode for batch with statusText
#    Examples:
#      | Scenario                  |
#      | Existing batch Number     |
#      | MissingMandatoryField     |
#      | Invalid endpoint          |
#      | Inactive progId           |
#      | Invalid data              |
#      | Missing additional fields |
#      | Valid details             |
#
