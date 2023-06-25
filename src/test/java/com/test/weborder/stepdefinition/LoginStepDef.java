package com.test.weborder.stepdefinition;

import Utils.DriverHelper;
import com.test.weborder.pages.WebOrder_LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrder_LoginPage webOrderLoginPage=new WebOrder_LoginPage(driver);
    @When("User enters the correct username {string} and password {string} and clicks login button")
    public void user_enters_the_correct_username_and_password_and_clicks_login_button(String username, String password) {
       webOrderLoginPage.loginFunctionality(username,password);
    }
    @Then("User validates the mainPage {string}")
    public void user_validates_the_main_page(String expectedMessage) {
     Assert.assertEquals(expectedMessage,driver.getTitle().trim());
    }
    @When("User enters the username {string} and password {string} and clicks login button")
    public void user_enters_the_username_and_password_and_clicks_login_button(String username, String password) {
      webOrderLoginPage.loginFunctionality(username,password);
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
       Assert.assertEquals(webOrderLoginPage.errorMessage(),expectedMessage);
    }
    @When("User enters the username {string} and password {string} and User clicks login button")
    public void user_enters_the_username_and_password_and_user_clicks_login_button(String username, String password) {
       webOrderLoginPage.loginFunctionality(username,password);
    }



}
