@RestAssured
Feature: First api validation
  

@Test
  Scenario: Find the Pet by Pet Id
    Given prepare the api with Http Method "Get"
    When execute the request
    Then validate the Response 
    
 @Test
  Scenario: Add a new user in reqres portal
    Given prepare the api with Http Method "Post"
    When execute the request
    Then validate the Response status code "201"
    
    
  @Test
   Scenario: update a user in reqres portal
    Given prepare the api with Http Method "Put"
    When execute the request
     Then validate the Response status code "200"

