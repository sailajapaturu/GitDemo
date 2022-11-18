
@tag
  Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from cart and Checkout product and submit the order
    Then 	message is displayed on ConfirmationPage

    Examples: 
      | name  									| password 			| productName	|
      | sailajapaturu@gmail.com | Moksha@16     | ZARA COAT 3	|
      
