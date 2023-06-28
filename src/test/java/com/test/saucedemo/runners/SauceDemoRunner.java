package com.test.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/saucedemo",
        glue="com/test/saucedemo/stepdefinition",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class SauceDemoRunner {
}
