Feature: Portfolio career feature
  Scenario: Produce bug in career endpoint
  Given User go to path career "/career"
  And User click career, for example "Angular Developer"
  And User redirect to "Angular Developer" career page
  When User change career endpoint to "56"
  Then User will see "Recruitment Officer" career page with invalid current endpoint