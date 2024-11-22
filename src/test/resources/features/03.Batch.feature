#@Batch
#Feature: Create new Batch
#
#
#  @Batch
#
#  Background:
#  Admin sets Authorization to No Auth
#
#  Scenario: Check if admin able to create a Batch with valid endpoint and request body without authorization
#    Given Admin creates POST Request  with valid data in request body
#    When Admin sends HTTPS Request with endpoint
#    Then Admin receives 401 Unauthorized
