package com.sip.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "@target/failed.txt",
        glue = {"com/sip/steps", "com/sip/Hooks"},
        tags="@HomeTest",
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed1.txt"},
        monochrome = true
)
public class FailRunner extends AbstractTestNGCucumberTests {
}
