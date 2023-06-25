package com.test.weborder.pages;

import Utils.BrowsersUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrder_OrderPage {
    public WebOrder_OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;
    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;
    @FindBy(css = "#InviteNote")
    WebElement noteSession;
    @FindBy(css = "#InviteList")
    WebElement inviteList;
    @FindBy(xpath = "//select[@id='ConfirmAddressID']")
    WebElement locationOptions;
    @FindBy(css = "#addressPreview")
    WebElement addressPreView;
    @FindBy(css = "#createGroupOrder")
    WebElement groupOrderButton;
    @FindBy(css = ".topBannerHeader")
    WebElement header;
    @FindBy(xpath = "//p[contains(text(),'pending')]")
    WebElement description;

    public void startGroupOrder(){//can create 2 methods since not every order can be group order
        if (groupOrderBox.isEnabled() && groupOrderBox.isDisplayed() && !groupOrderBox.isSelected()){
            groupOrderBox.click();
        }
        nextButton.click();
    }
    //can create 2 methods for this, since the note and invitees are optional
    //for future usage
    public void sendMessage(String message) throws InterruptedException {
        noteSession.sendKeys(message);

    }
    public void addInvitees(String invitee1, String invitee2) {
    inviteList.sendKeys(invitee1 +"," +invitee2);
    }
    public void addressConfirmation(String expectedAddress){
        BrowsersUtils.selectBy(locationOptions,"My House","text");
       //"my house“ can be parameterized, just to be more professional
        Assert.assertTrue(BrowsersUtils.getText(addressPreView).contains(expectedAddress));
    }
    public void officeAddressConfirmation(String location,String expectedAddress){
        BrowsersUtils.selectBy(locationOptions,location,"text");
        //"my house“ can be parameterized, just to be more professional
        Assert.assertTrue(BrowsersUtils.getText(addressPreView).contains(expectedAddress));
    }

    public void generateGroupOrder(String expectedHeader, String expectedDescription) throws InterruptedException {
        groupOrderButton.click();
        Thread.sleep(4000);
        Assert.assertEquals(expectedHeader,BrowsersUtils.getText(header));
        Assert.assertTrue(BrowsersUtils.getText(description).contains(expectedDescription));
    }



}
