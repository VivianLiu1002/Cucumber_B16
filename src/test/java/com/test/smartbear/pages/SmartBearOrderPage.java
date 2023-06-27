package com.test.smartbear.pages;

import Utils.BrowsersUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage {
    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "select")
    WebElement productOptions;
    @FindBy(xpath = "//input[contains(@name,'txtQuantity')]")
    WebElement quantity;
    @FindBy(xpath = "//input[contains(@name,'txtName')]")
    WebElement name;
    @FindBy(xpath = "//input[contains(@name,'TextBox2')]")
    WebElement street;
    @FindBy(xpath = "//input[contains(@name,'TextBox3')]")
    WebElement city;
    @FindBy(xpath = "//input[contains(@name,'TextBox4')]")
    WebElement state;
    @FindBy(xpath = "//input[contains(@name,'TextBox5')]")
    WebElement zip;
    @FindBy(xpath = " //input[@value='Visa']")
    WebElement visa;
    @FindBy(xpath = "//input[@value='MasterCard']")
    WebElement masterCard;
    @FindBy(xpath = " //input[@value='American Express']")
    WebElement Amex;
    @FindBy(xpath = "//input[contains(@name,'TextBox6')]")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expirationDate;
    @FindBy(xpath = "//a[.='Process']")
    WebElement processButton;
    @FindBy(xpath = "//strong")
    WebElement orderMessage;


    public void enterProductInfo(String product, String quantity){
        BrowsersUtils.selectBy(productOptions,product,"text");
        this.quantity.sendKeys(quantity);
    }

    public void enterAddressInfo(String name, String street, String city,String state, String zip){
        this.name.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }
    public void enterCardInfo(String cardType, String cardNumber,String expirationDate){
        switch (cardType.toLowerCase()){
            case "visa":
                if (visa.isEnabled() && visa.isDisplayed() && !visa.isSelected()) {
                    visa.click();
                }break;
            case "mastercard":
                if(masterCard.isEnabled() && masterCard.isDisplayed() && !masterCard.isSelected()) {
                    masterCard.click();
                }break;
            case "american express":
            if (Amex.isEnabled() && Amex.isDisplayed() && !Amex.isSelected()) {
                Amex.click();
            }break;
        }
        this.cardNumber.sendKeys(cardNumber);
        this.expirationDate.sendKeys(expirationDate);
    }

    public void processOrder(String expectedMessage){
        processButton.click();
        Assert.assertEquals(expectedMessage,BrowsersUtils.getText(orderMessage));
    }
}
