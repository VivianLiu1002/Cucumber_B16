package com.test.saucedemo.stepdefinition;

import Utils.DriverHelper;
import com.test.saucedemo.pages.SauceDemo_CartPage;
import com.test.saucedemo.pages.SauceDemo_CheckoutPage;
import com.test.saucedemo.pages.SauceDemo_LoginPage;
import com.test.saucedemo.pages.SauceDemo_MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class SauceDemo_StepDef {
    WebDriver driver= DriverHelper.getDriver();
    SauceDemo_LoginPage sauceDemoLoginPage=new SauceDemo_LoginPage(driver);
    SauceDemo_MainPage sauceDemoMainPage=new SauceDemo_MainPage(driver);
    SauceDemo_CartPage sauceDemoCartPage=new SauceDemo_CartPage(driver);
    SauceDemo_CheckoutPage sauceDemoCheckoutPage=new SauceDemo_CheckoutPage(driver);
    @Given("User enters username and password to login successfully")
    public void user_enters_username_and_password_to_login_successfully() {
       sauceDemoLoginPage.login();
    }
    @When("User chooses {string} and clicks add to cart button")
    public void user_chooses_and_clicks_add_to_cart_button(String itemName) {
       sauceDemoMainPage.selectItem(itemName);
       sauceDemoMainPage.clickAddToCartButton();

    }
    @Then("User clicks the cart sign and clicks checkout button")
    public void user_clicks_the_cart_sign_and_clicks_checkout_button() {
      sauceDemoMainPage.clickCartLogo();
      sauceDemoCartPage.clickCheckOutButton();

    }
    @Then("User fills out boxes for {string},{string},{string} and clicks continue button")
    public void user_fills_out_boxes_for_and_clicks_continue_button(String firstName, String lastName, String zipCode) throws InterruptedException {
        sauceDemoCheckoutPage.enterCheckOutInfo(firstName,lastName,zipCode);
        sauceDemoCheckoutPage.clickContinueButton();
    }
    @Then("User validates the {string},{string} and eight percent tax amount and the total amount is matching with tax + item Total")
    public void user_validates_the_and_eight_percent_tax_amount_and_the_total_amount_is_matching_with_tax_item_total(String nameOfProduct, String itemTotal) {
        sauceDemoCheckoutPage.validateOrderInfo(nameOfProduct,itemTotal);
    }
    @Then("User clicks finish button and validate {string} message")
    public void user_clicks_finish_button_and_validate_message(String expectedHeader) {
        sauceDemoCheckoutPage.clickFinishButton();
        sauceDemoCheckoutPage.validateHeader(expectedHeader);
    }
    @When("User chooses itemName and clicks add to cart button")
    public void user_chooses_item_name_and_clicks_add_to_cart_button(DataTable dataTable) {
        Map <String,String> itemName=dataTable.asMap();
        sauceDemoMainPage.selectItem(itemName.get("itemName"));
        sauceDemoMainPage.clickAddToCartButton();
    }

    @Then("User fills out boxes for firstName,lastName,zipCode and clicks continue button")
    public void user_fills_out_boxes_for_first_name_last_name_zip_code_and_clicks_continue_button(DataTable dataTable) {
        Map <String,String> checkOutInfo=dataTable.asMap();
        sauceDemoCheckoutPage.enterCheckOutInfo(checkOutInfo.get("firstName"),
                checkOutInfo.get("lastName"),checkOutInfo.get("zipCode"));
        sauceDemoCheckoutPage.clickContinueButton();
    }

    @Then("User validates the itemName,itemTotal and eight percent tax amount and the total amount is matching with tax + item Total")
    public void user_validates_the_item_name_item_total_and_eight_percent_tax_amount_and_the_total_amount_is_matching_with_tax_item_total(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> orderInfo=dataTable.asMap();
        sauceDemoCheckoutPage.validateOrderInfo(orderInfo.get("itemName"),
                                                 orderInfo.get("itemTotal"));
    }

    @Then("User clicks finish button and validate message")
    public void user_clicks_finish_button_and_validate_message(io.cucumber.datatable.DataTable dataTable) {
       sauceDemoCheckoutPage.clickFinishButton();
        List<String> message=dataTable.asList();
        sauceDemoCheckoutPage.validateHeader(message.get(0));
    }





}
