#
#1-First Create your hook class and your @Before and @After annotation(io.cucumber)
#2-Read username,password,url from configuration.properties
#3-Start writing your test case in feature file
#4-Start creating your Page object model(pages,step definitions,runners)
#tips:You should have :LoginPage,MainPage,OrderPage,ViewOrderPage(validation part)
#tips:You should have :OrderCreationStepDef
#5-Create your runner class and get the all snips from Runner class(DryRun=True)
#6-Put the snips in step def class
#7-Start implementing your page classes(WebElements and Methods)
#8-Convert the logic of Scenario to Scenario Outline
#-->Check it for MyMoney,FamilyAlbum,ScreenSaver
#-->Check it for Visa,MasterCard,AmericanExpress
#TIPS:Validation part:You can do Arrays.asList logic we did before
#but start from 1 and end lenght-1.
#
@regression
Feature: Testing Order Creation Functionality of SmartBear website

  Scenario Outline: creating the WebOrder from SmartBear
    Given User gives username and password and clicks loginButton
    When User clicks order category button and provides Product Information: '<product>' and '<quantity>'
    And User gives Address Information: '<name>','<street>','<city>','<state>','<zip>'
    And User gives Payment Information: '<cardType>','<cardNumber>','<expirationDate>'
    Then User clicks process button and validates the order message '<orderMessage>' and clicks view order button
    Then User validates all information '<name>', '<product>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>','<cardNumber>','<expirationDate>' from table
    Examples:
      | product     | quantity | name   | street               | city        | state | zip   | cardType         | cardNumber | expirationDate | orderMessage                           |
      | MyMoney     | 4        | Vivian | 123 Main St.         | Chicago     | IL    | 60616 | Visa             | 123456789  | 01/25          | New order has been successfully added. |
      | FamilyAlbum | 3        | Alex   | 456 Washington Blvd. | Des Plaines | IL    | 60606 | MasterCard       | 567894565  | 03/27          | New order has been successfully added. |
      | ScreenSaver | 5        | Sam    | 789 Lake St.         | Chicago     | IL    | 60695 | American Express | 335544885  | 11/26          | New order has been successfully added. |


    #the scenario needs to be repeated 3 times if we want the same data as above
  #the snips it generate is different as well. "complicated"
  Scenario: validation the WebOrder from SmartBear with DataTable
    Given User gives username and password and clicks loginButton
    When User clicks OrderButton and provides the product and quantity for product information
      #acts like Map
      | product  | MyMoney |
      | quantity | 4       |

    And User provides customerName,street,city,state,zipcode for address information
      | customerName | Ahmet       |
      | street       | 123 Main St |
      | city         | Chicago     |
      | state        | IL          |
      | zipCode      | 60102       |
    And User provides cardtype,cardNumber,expirationDate for payment information
      | cardType       | visa    |
      | cardNumber     | 1455221 |
      | expirationDate | 06/25   |
    And User clicks process button and validates message
      | New order has been successfully added. |



