Feature: Assignment Feature
  
  Background: Navigate to Home Page
  	Given user navigate to home page
  
  @Test1 @All
  Scenario: To automate Test_1
    When user is on home page 
    Then user verify and enter "testuser@email.com" in username field
    Then user verify and enter "testpass" in password field
    And user verify and click on login button
  
  @Test2 @All
  Scenario: To automate Test_2
    When user is on home page
    Then user verify 3 values in listgroup
    Then user verify second list item is "List Item 2"
    And user verify second list item badge value is "6"
  
  @Test3 @All
  Scenario: To automate Test_3
    When user is on home page
    Then user verify "Option 1" is the default selected value
    Then user selects "Option 3" from the select list
  
  @Test4 @All
  Scenario: To automate Test_4
    When user is on home page
    Then user verify the first button is enabled 
    And user verify the second button is disabled
  
   @Test5 @All
   Scenario: To automate Test_5
    When user is on home page
    Then user clicks on button
    And user verify success message is displayed 
    Then user verify the button is disabled
    
    @Test6 @All
   Scenario: To automate Test_6
    When user is on home page
    Then user provides 2 as row and 2 as column number
    Then verifies the value "Ventosanzap"
    