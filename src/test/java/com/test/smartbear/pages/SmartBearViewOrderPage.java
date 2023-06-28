package com.test.smartbear.pages;

import Utils.BrowsersUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now=LocalDateTime.now().plusDays(1);
        String currentDate=dtf.format(now);

        List<String> expectedInfo= Arrays.asList("",name, product, quantity, currentDate, street, city,
                state, zip, cardType, cardNumber, expirationDate,"");//we don't validate the first and last element
        for (int i=1; i<orderData.size()-1;i++){
            Assert.assertEquals(expectedInfo.get(i), BrowsersUtils.getText(orderData.get(i)));
        }
    }
}
