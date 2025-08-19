package com.dikahadir.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/features/jabatan/TambahJabatan.feature",
        "src/test/resources/features/jabatan/FilterJabatan.feature",
        "src/test/resources/features/jabatan/ResetFilterJabatan.feature"
    },
    glue = {
        "com.dikahadir",                  
        "com.dikahadir.definitions.jabatan"
    },
    plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-report/cucumber.json"
    }
)
public class RunnerJabatanTest extends AbstractTestNGCucumberTests {
}
