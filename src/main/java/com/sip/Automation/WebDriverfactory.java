package com.sip.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverfactory {
    protected static WebDriver driver;

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
}
