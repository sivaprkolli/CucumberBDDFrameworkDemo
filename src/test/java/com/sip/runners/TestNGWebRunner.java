package com.sip.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/sip/steps", "com/sip/Hooks"},
        tags="@HomeTest",
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed.txt"},
        monochrome = true
)
public class TestNGWebRunner extends AbstractTestNGCucumberTests {
}
