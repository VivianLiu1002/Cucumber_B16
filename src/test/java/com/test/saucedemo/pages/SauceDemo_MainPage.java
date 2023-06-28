package com.test.saucedemo.pages;

import Utils.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemo_MainPage {
    public SauceDemo_MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a//div")
    List<WebElement> allItems;
    @FindBy(xpath = "//button[.='Add to cart']")
    WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartLogo;

    public void selectItem(String itemName){
        for (WebElement item :allItems){
            if (BrowsersUtils.getText(item).contains(itemName)){
                item.click();
                break;
            }
        }
    }
    public void clickAddToCartButton(){
        addToCartButton.click();
    }
    public void clickCartLogo(){
        cartLogo.click();
    }

}
