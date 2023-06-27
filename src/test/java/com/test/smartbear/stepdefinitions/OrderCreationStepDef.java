package com.test.smartbear.stepdefinitions;

import Utils.CongfigReader;
import Utils.DriverHelper;
import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewOrderPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class OrderCreationStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);
    SmartBearViewOrderPage smartBearViewOrderPage=new SmartBearViewOrderPage(driver);

    @Given("User gives username and password and clicks loginButton")
    public void user_gives_username_and_password_and_clicks_login_button() {
      smartBearLoginPage.login(CongfigReader.readProperty("smartBear_username"),
                      CongfigReader.readProperty("smartBear_password")) ;
    }
    @When("User clicks order category button and provides Product Information: {string} and {string}")
    public void user_clicks_order_category_button_and_provides_product_information_and(String product, String quantity) {
    smartBearMainPage.clickOrderButton();
    smartBearOrderPage.enterProductInfo(product,quantity);
    }
    @When("User gives Address Information: {string},{string},{string},{string},{string}")
    public void user_gives_address_information(String name, String street, String city, String state, String zip) {
        smartBearOrderPage.enterAddressInfo(name,street,city,state,zip);
    }
    @When("User gives Payment Information: {string},{string},{string}")
    public void user_gives_payment_information(String cardType, String cardNumber, String expirationDate) {
        smartBearOrderPage.enterCardInfo(cardType,cardNumber,expirationDate);
    }
    @Then("User clicks process button and validates the order message {string} and clicks view order button")
    public void user_clicks_process_button_and_validates_the_order_message_and_clicks_view_order_button(String expectedMessage) {
        smartBearOrderPage.processOrder(expectedMessage);
    }

    @Then("User validates all information {string}, {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_java_time_local_date_from_table(String name,String product,String quantity,String date, String street,
                                                                               String city,String state,String zip,String cardType,String cardNumber,String expirationDate) {
        smartBearMainPage.clickViewAllOrderButton();
        smartBearViewOrderPage.orderConfirm(name, product, quantity, date, street, city,
                state, zip, cardType, cardNumber, expirationDate);
    }


}
