package com.test.saucedemo.pages;

import Utils.BrowsersUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

public class SauceDemo_CheckoutPage {
    public SauceDemo_CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement zipCode;

    @FindBy(css = "#continue")
    WebElement continueButton;
    @FindBy(css = ".inventory_item_name")
    WebElement nameOfProduct;
    @FindBy(css = ".summary_subtotal_label")
    WebElement subTotal;
    @FindBy(css = ".summary_tax_label")
    WebElement tax;
    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    WebElement totalPrice;
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy(css = ".complete-header")
    WebElement header;


    public void enterCheckOutInfo(String firstName, String lastName, String zipCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void validateOrderInfo(String nameOfProduct, String itemTotal){
        Assert.assertTrue(BrowsersUtils.getText(this.nameOfProduct).contains(nameOfProduct));
        Assert.assertTrue(BrowsersUtils.getText(subTotal).contains(itemTotal));

        double taxPercent=Math.round((Double.parseDouble(itemTotal.replace("$",""))*0.08)*100)/100.0;
        String taxAmount=String.valueOf(taxPercent);
//        System.out.println(taxPercent);
//        System.out.println(taxAmount);
        Assert.assertTrue(BrowsersUtils.getText(tax).contains(taxAmount));

        DecimalFormat dFormat=new DecimalFormat("0.00");
        String totalAmount= dFormat.format(Double.parseDouble(itemTotal.replace("$",""))+taxPercent);
//        System.out.println(totalAmount);
//        System.out.println(BrowsersUtils.getText(totalPrice));
        Assert.assertTrue(BrowsersUtils.getText(totalPrice).contains(totalAmount));
    }
    public void clickFinishButton(){
        finishButton.click();
    }
    public void validateHeader(String expectedHeader){
        Assert.assertEquals(expectedHeader,BrowsersUtils.getText(header));
    }




}
