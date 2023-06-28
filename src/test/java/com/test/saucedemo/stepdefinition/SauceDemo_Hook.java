package com.test.saucedemo.stepdefinition;

import Utils.BrowsersUtils;
import Utils.CongfigReader;
import Utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class SauceDemo_Hook {
    WebDriver driver= DriverHelper.getDriver();
    @Before
    public void setup(){
        driver.get(CongfigReader.readProperty("sauceDemo_url"));

    }
    @After
    public void tearDown(Scenario scenario){
        BrowsersUtils.getScreenshotForCucumber(driver,scenario);
        driver.quit();
    }
}
