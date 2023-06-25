package com.test.google.stepDefinitions;

import Utils.DriverHelper;
import com.test.google.pages.GoogleMainPage;
import io.cucumber.core.cli.Main;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to Google")
    public void user_navigates_to_google() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.google.com/");

    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        // Write code here that turns the phrase above into concrete actions
        googleMainPage.searchItem("CodeFish");

    }
    @Then("User validates first page returns more than ten links")
    public void user_validates_first_page_returns_more_than_ten_links() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(googleMainPage.linkCount(10));
    }
    @When("User searches for Kyrgyz Food In USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
        // Write code here that turns the phrase above into concrete actions
       googleMainPage.searchItem("Kyrgyz Food In USA");
    }
    @Then("User validates the result is less than three hundred millions")
    public void user_validates_the_result_is_less_than_three_hundred_millions() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(googleMainPage.resultsFromSearch(300000000));
    }
    @When("User searches for Turkish baklava")
    public void user_searches_for_turkish_baklava() {
        googleMainPage.searchItem("Turkish baklava");
    }

    @Then("User validates the loading time is less than one second")
    public void user_validates_the_search_time_is_less_than_second() {
       Assert.assertTrue( googleMainPage.timingFromResearch(1.0));
    }

}
