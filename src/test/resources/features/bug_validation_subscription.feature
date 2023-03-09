Feature: subscription email feature
  Scenario: Produce bug in subscription email
    Given User go to path home "/"
    And User scroll page until down
    When User fill in field email subscription "ini_testing@coba.com"
    Then User click button subscribe
    And validate success message