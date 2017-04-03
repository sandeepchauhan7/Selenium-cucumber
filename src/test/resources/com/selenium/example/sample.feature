@smokeTest
Feature: To test my cucumber test is running
I want to run a sample feature file.

 Scenario: I login with valid credential
       Given I navigate to "https://34.200.9.250:9002/PE/es_PE/login"
       And I enter "Guido" into input field having id "register.firstName"
       And I enter "Maiola" into input field having id "register.lastName"
       And I enter "guidomaiola@gmail.com.com" into input field having id "register.email"
       And I enter "Pass1234" into input field having id "password"
       And I enter "Pass1234" into input field having id "register.checkPwd"
       When I press enter
       And I wait for 15 sec
       Then I close browser