package com.test.google.pages;

import Utils.BrowsersUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBar;
    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;
    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement result;
    @FindBy(xpath = "//nobr")
    WebElement loadingTime;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linkCount(int expectedNumber) throws InterruptedException {
        Thread.sleep(2000);
        return allLinks.size()>expectedNumber;
    }
    public boolean resultsFromSearch(int expectedResult){
        String[] result= BrowsersUtils.getText(this.result).split(" ");//About 129,000,000 results (0.55 seconds)
        return Integer.parseInt(result[1].replace(",","")) < expectedResult;

    }
    public boolean timingFromResearch(double expectedTiming){
        String[] timing=BrowsersUtils.getText(loadingTime).split(" ");//(0.48 seconds) --> [0.77, seconds)
        return Double.parseDouble(timing[0].replace("(","")) < expectedTiming;
    }

}
