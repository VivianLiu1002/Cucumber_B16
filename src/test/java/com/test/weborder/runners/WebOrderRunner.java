package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/weborder",//feature file location
        glue="com/test/weborder/stepdefinition",//step definitions file location
        dryRun = false,//only gives the undefined snips, instead of running the whole thing
        //remember to convert it to false after getting the snips
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
        //creates the report file and another file for failed tests


)
public class WebOrderRunner {

}
