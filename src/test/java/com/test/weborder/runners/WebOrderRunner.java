package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/weborder",//feature file location
        glue="com/test/weborder/stepdefinition",//step definitions file location
        dryRun = true//only gives the undefined snips, instead of running the whole thing
        //remember to convert it to false after getting the snips

)
public class WebOrderRunner {

}
