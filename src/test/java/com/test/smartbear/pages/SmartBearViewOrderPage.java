package com.test.smartbear.pages;

import Utils.BrowsersUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SmartBearViewOrderPage {
    public SmartBearViewOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//table[@class='SampleTable']//tr[2]//td")
    List<WebElement> orderData;

    public void orderConfirm(String name,String product,String quantity,String street,
    String city,String state,String zip,String cardType,String cardNumber,String expirationDate){
        List<String> expectedInfo= Arrays.asList(name, product, quantity, street, city,
                state, zip, cardType, cardNumber, expirationDate);
        for (int i=1,k=0; i<orderData.size()-1;i++, k++){
            Assert.assertEquals(expectedInfo.get(k), BrowsersUtils.getText(orderData.get(i)));
        }
    }
}
