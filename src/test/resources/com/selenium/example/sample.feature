@smokeTest
Feature: To test my cucumber test is running
I want to run a sample feature file.

 Scenario: I register with valid credential
       Given I navigate to "https://34.200.9.250:9002/PE/es_PE/login" in firefox
       And I enter "Guido" into input field having id "register.firstName"
       And I enter "Maiola" into input field having id "register.lastName"
       And I enter "guidomaiola@gmail.com.com" into input field having id "register.email"
       And I enter "Pass1234" into input field having id "password"
       And I enter "Pass1234" into input field having id "register.checkPwd"
       When I press enter
       And I wait for 15 sec
	   And take screenshot with filename "screenshot1.png" 
       Then I close browser
 
  Scenario: I login with valid credential
       Given I navigate to "https://34.200.9.250:9002/PE/es_PE/login" in headless browser
       And I enter "Guido" into input field having id "j_username"
       And I enter "Maiola" into input field having id "j_password"
       When I press Login
       And I wait for 15 sec
	   And take screenshot with filename "screenshot2.png" 
       Then I close browser