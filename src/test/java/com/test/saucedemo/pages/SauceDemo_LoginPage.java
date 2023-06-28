package com.test.saucedemo.pages;

import Utils.CongfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_LoginPage {
    public SauceDemo_LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;

    public void login(){
        username.sendKeys(CongfigReader.readProperty("sauceDemo_username"));
        password.sendKeys(CongfigReader.readProperty("sauceDemo_password"));
        loginButton.click();
    }

}
