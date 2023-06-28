package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemo_CartPage {
    public SauceDemo_CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    public void clickCheckOutButton(){
        checkoutButton.click();
    }
}
