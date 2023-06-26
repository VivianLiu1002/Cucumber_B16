package com.test.weborder.pages;

import Utils.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrder_LoginPage {

    public WebOrder_LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#Email")
    WebElement email;
    @FindBy(css = "#Password")
    WebElement password;
    @FindBy(xpath = "//button[.='Sign In']")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement errorMessage;

    public void loginFunctionality(String username, String password){
        email.clear();
        email.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String errorMessage() throws InterruptedException {
        Thread.sleep(2000);
        return BrowsersUtils.getText(errorMessage);
    }

}
