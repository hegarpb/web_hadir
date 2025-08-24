package com.dikahadir.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/features/aturancuti/SearchAturanCuti.feature"

    },
    glue = {
        "com.dikahadir",                  
        "com.dikahadir.definitions.aturancuti"
    },
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-report/cucumber.json"
    }
)
public class RunnerAturanCutiTest extends AbstractTestNGCucumberTests {
}
