package com.sip.Hooks;

import com.sip.Automation.WebDriverfactory;
import com.sip.TestRailManager.TestRailClient;
import io.cucumber.java.*;

import static com.sip.ExtentManager.ExtentReportManager.closeReport;
import static com.sip.ExtentManager.ExtentReportManager.generateReport;

public class Hooks {

    private static final int RUN_ID = 16;  // Replace with your TestRail run ID

    @BeforeAll
    public static void initializeDrivers() {
        generateReport();
        WebDriverfactory.intializeDrivers();
    }

    @Before
    public static void beforeEveryScenario() {
        WebDriverfactory.launchApplication();
    }

    @BeforeStep
    public static void beforeEveryStep(Scenario method) {
        addReport(method);
    }

    @AfterAll
    public static void killSession(){
        WebDriverfactory.killSession();
    }


    //@After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
                //byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                //scenario.attach(screenshot, "image/png", "screenshot");
            WebDriverfactory wf = new WebDriverfactory();
            wf.getScreenshotForFailure();
        }
        closeReport();
    }



    @After
    public void afterScenario(Scenario scenario) {
        String testCaseId = extractTestCaseIdFromTags(scenario);
        int caseId = Integer.parseInt(testCaseId);  // Convert the case ID from your tags

        int statusId = scenario.isFailed() ? 5 : 1;  // 5=Failed, 1=Passed
        String comment = scenario.isFailed() ? scenario.getName() + " failed" : "Test passed";

        // Submit the test result to TestRail
        TestRailClient.addTestResult(RUN_ID, caseId, statusId, comment);
    }

    private String extractTestCaseIdFromTags(Scenario scenario) {
        // Loop through scenario tags to find the case ID (e.g., @T1234)
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.matches("@T\\d+")) {
                return tag.substring(2);  // Strip @T from the tag to get the test case ID
            }
        }
        throw new IllegalArgumentException("Test case ID not found in scenario tags");
    }


    public static void addReport(Scenario method){
        WebDriverfactory wf = new WebDriverfactory();
        wf.reportTest(method);
    }



}
