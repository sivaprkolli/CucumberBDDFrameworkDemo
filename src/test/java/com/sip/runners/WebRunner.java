package com.sip.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/sip/steps", "com/sip/Hooks"},
        tags="@HomeTest",
        plugin = {"pretty","com.aventstack.chaintest.plugins.ChainTestCucumberListener:", "rerun:target/failed.txt"},
        //plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "com.aventstack.chaintest.plugins.ChainTestCucumberListner:", "rerun:target/failed.txt"},
        monochrome = true
)
public class WebRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("================ BEFORE SUITE ================");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        System.out.println("before class");
        //context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(System.getProperty("parallel_threads")));
        //  context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(3);
    }
}
