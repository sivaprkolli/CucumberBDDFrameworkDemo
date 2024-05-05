package com.sip.steps;

import com.sip.Automation.WebDriverfactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    @BeforeAll
    public static void initializeDrivers() {
        WebDriverfactory.intializeDrivers();
    }

    @Before
    public static void beforeEveryScenario() {
        WebDriverfactory.launchApplication();
    }

    @BeforeStep
    public static void beforeEveryStep() {

    }

    @AfterAll
    public static void killSession(){
        WebDriverfactory.killSession();
    }
}
