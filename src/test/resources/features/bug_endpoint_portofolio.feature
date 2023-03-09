Feature: Portfolio endpoint feature
  Scenario: Produce bug in Portfolio endpoint
  Given User go to path portfolio "/portfolio"
  And User click portfolio, for example "Portal Project"
  And User redirect to "Portal Project" portfolio page
  When User change endpoint to "86"
  Then User will see PLN Project portfolio page with invalid current endpoint