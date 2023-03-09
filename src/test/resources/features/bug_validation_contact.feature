Feature: Portfolio contact feature
  Scenario: Produce bug in contact endpoint
  Given User go to path contact "/contact"
  And User redirect to contact page "Contact Javan Cipta Solusi"
  When User fill full name with "rip rip test"
  And User fill Nick Name with "r1p_rip_yo"
  And User fill email with "admin@try.my.id"
  And User fill Phone or Whatsapp "085156743333"
  And User fill Company or Institution "Universitas of neraka"
  And User choose dropdown option "Ads"
  And User fill Tell us what you need "hello, this is a testing. ignore it. hello, this is a testing. ignore it. hello, this is a testing. ignore it. hello, this is a testing. ignore it"
  And User check captcha
  Then User click Send Button
  And validate success message from contact