@RestAssured
Feature: First api validation
  

@Test
  Scenario: Find the Pet by Pet Id
    Given prepare the api with Http Method "Get"
    When execute the request
    Then validate the Response
    
    
    
 @Test
  Scenario: Add a New pet information
    Given prepare the api with Http Method "Post"
    When execute the request
    Then validate the Response


