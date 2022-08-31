Feature: Login User

  Scenario: User invalid login
    Given User go to Web HRM
    When User enter username password
    And User click button login
    Then User invalid credentials
  
  Scenario: User valid login
    Given User go to Web HRM
    When User enter username password valid
    And User click button login valid
    Then User valid credentials
