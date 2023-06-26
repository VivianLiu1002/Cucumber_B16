package com.test.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
   features = "@target/uiFailedTests.txt",//it runs all files located under this txt file
           glue = "com/test/weborder/stepdefinition",
           tags = "@regression",
           plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
           )
public class SmartBearReRunner {
}
