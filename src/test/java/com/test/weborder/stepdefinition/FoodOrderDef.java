package com.test.weborder.stepdefinition;

import Utils.DriverHelper;
import com.test.weborder.pages.WebOrder_LoginPage;
import com.test.weborder.pages.WebOrder_OrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FoodOrderDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrder_OrderPage webOrderOrderPage=new WebOrder_OrderPage(driver);

    @Then("User checks the group order box and clicks next button")
    public void user_checks_the_group_order_box_and_clicks_next_button() {
        webOrderOrderPage.startGroupOrder();

    }
    @Then("User sends {string} message at invitees section and add {string} and {string} to the inviteeList")
    public void user_sends_message_at_invitees_section_and_add_and_to_the_invitee_list(String message, String invitee1, String invitee2) throws InterruptedException {
        webOrderOrderPage.sendMessage(message);
        webOrderOrderPage.addInvitees(invitee1,invitee2);
    }
    @Then("User chooses the delivery option my house and validates the address contains {string}")
    public void user_chooses_the_delivery_option_my_house_and_validates_the_address_contains( String expectedMessage) {
       webOrderOrderPage.addressConfirmation(expectedMessage);
    }
    @Then("User clicks group order button and validates the header {string} and description contains {string}")
    public void user_clicks_group_order_button_and_validates_the_header_and_description_contains(String expectedHeader, String expectedDescription) throws InterruptedException {
        webOrderOrderPage.generateGroupOrder(expectedHeader,expectedDescription);
    }

    @When("User sends {string} message at invitees section")
    public void user_sends_message_at_invitees_section(String message) throws InterruptedException {
        webOrderOrderPage.sendMessage(message);
    }
    @When("add {string} and {string} to the inviteeList")
    public void add_and_to_the_invitee_list(String invitee1, String invitee2) {
        webOrderOrderPage.addInvitees(invitee1,invitee2);
    }
    @Then("User chooses the delivery option {string} and validates the address contains {string}")
    public void user_chooses_the_delivery_option_and_validates_the_address_contains(String office, String expectedAddress ) {
        webOrderOrderPage.officeAddressConfirmation(office,expectedAddress);
    }

}
