package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.types.Feature;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTests.txt",//it runs all files located under this txt file
        glue = "com/test/smartbear/stepdefinitions",
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
        //re-run this class after the issue is fixed, only the failed ones will run
        // the file and report will be automatically updated
)


public class WebOrderReRunner {

}
