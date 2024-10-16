package com.sip.Automation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class WebDriverfactory {
    protected static WebDriver driver;

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void intializeDrivers() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void launchApplication() {
        driver.get("https://www.saucedemo.com/");
    }

    public static void killSession(){
        driver.quit();
    }

    public void reportTest(Scenario method) {
        test = extent.createTest(this.getClass().getSimpleName() + "::" + method.getName());
    }

    public void getScreenshotForFailure(){
        test.log(Status.FAIL, "");

        test.fail("details",
                MediaEntityBuilder.createScreenCaptureFromBase64String("Test").build());

    }

}
