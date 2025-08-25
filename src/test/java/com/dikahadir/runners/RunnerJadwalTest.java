package com.dikahadir.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/features/jadwal/SearchJadwal.feature"

    },
    glue = {
        "com.dikahadir",                  
        "com.dikahadir.definitions.jadwal"
    },
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-report/cucumber.json"
    }
)
public class RunnerJadwalTest extends AbstractTestNGCucumberTests {
}
