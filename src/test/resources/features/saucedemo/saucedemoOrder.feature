#HOMEWORK: url=https://www.saucedemo.com/
#1-User login successfully(username and password should come from config reader)
#2-User chooses first item and click Add to Cart button
#3-Click Cart sign on the top right
#4-Click checkout button
#5-fill all the box(firstname,lastname,postalcOde) and click continue button
#6-Validate the name of product, item total, and tax amount should be %8
#of the product and validate total amount is matching with tax+item total
#7-Click Finish Button and validate Thank you for your order message
#NOTE:DO this with Scenario outline for all items 1 by one
#NOTE:Do one of the items with DATA-TABLE (edited)
@regression
Feature: Testing to place order on SauceDemo website

  Scenario Outline: Testing order functionality and item price
    Given User enters username and password to login successfully
    When User chooses '<itemName>' and clicks add to cart button
    Then User clicks the cart sign and clicks checkout button
    And User fills out boxes for '<firstName>','<lastName>','<zipCode>' and clicks continue button
    Then User validates the '<itemName>','<item total>' and eight percent tax amount and the total amount is matching with tax + item Total
    Then User clicks finish button and validate 'Thank you for your order!' message
    Examples:
      | itemName                 | firstName | lastName | zipCode | item total |
      | Sauce Labs Backpack      | Vivian    | Liu      | 60102   | $29.99     |
      | Sauce Labs Bike Light    | Sam       | Smith    | 60111   | $9.99      |
      | Sauce Labs Bolt T-Shirt  | Jennifer  | Lopez    | 61612   | $15.99     |
      | Sauce Labs Fleece Jacket | John      | Doe      | 60155   | $49.99     |
      | Sauce Labs Onesie        | Alex      | Hill     | 61612   | $7.99      |

  Scenario: validate order functionality and item price from SauceDemo with DataTable
    Given User enters username and password to login successfully
    When User chooses itemName and clicks add to cart button
      | itemName | Test.allTheThings() T-Shirt (Red) |
    Then User clicks the cart sign and clicks checkout button
    And User fills out boxes for firstName,lastName,zipCode and clicks continue button
      | firstName | Linda |
      | lastName  | Hong  |
      | zipCode   | 34567 |
    Then User validates the itemName,itemTotal and eight percent tax amount and the total amount is matching with tax + item Total
      | itemName  | Test.allTheThings() T-Shirt (Red) |
      | itemTotal | $15.99              |
    Then User clicks finish button and validate message
      | Thank you for your order!|

