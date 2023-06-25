package com.test.google.stepDefinitions;

import Utils.DriverHelper;
import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchStepParameterDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    @Given("User navigates to {string}")
    public void user_navigates_to(String website) {
        driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
        googleMainPage.searchItem(searchItem);
    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(Integer expectedLink) throws InterruptedException {
        Assert.assertTrue(googleMainPage.linkCount(expectedLink));
    }
    @Then("User validates the result is less than {int}")
    public void user_validates_the_result_is_less_than(Integer resultCount) throws InterruptedException {
        Assert.assertTrue(googleMainPage.resultsFromSearch(resultCount));
    }

    @Then("User validates the loading time is less than {double}")
    public void user_validates_the_loading_time_is_less_than(Double expectedTime) {
       Assert.assertTrue(googleMainPage.timingFromResearch(expectedTime));
    }

}
