@tag
Feature: Testing Operations of Calculator
  I want test all the operations of Calculator

  @tag1
  Scenario: Test add method of Calculator
    Given create the object of Calculator
    When I pass 3 and 4
    Then add method should return 7
    
  @tag2
  Scenario: Test sub method of Calculator
    Given with the object of Calculator
    When I pass 8 and 4
    Then sub method should return 4