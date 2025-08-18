package com.dikahadir.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
    "src/test/resources/features/TambahJabatan.feature"
},glue={
    "com.dikahadir.definitions.jabatan"
},plugin = {
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-report/cucumber.json"
}
)

public class RunnersJabatan extends AbstractTestNGCucumberTests{
    
}
