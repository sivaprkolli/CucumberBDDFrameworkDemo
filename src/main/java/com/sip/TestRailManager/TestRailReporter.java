package com.sip.TestRailManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRailReporter {
    public static String TEST_RUN_ID = "16";
    public static String TESTRAIL_USERNAME = "siva9kolli@gmail.com";
    public static String TESTRAIL_PASSWORD = "Appium@123";
    public static String RAILS_URL = "https://automateapps.testrail.io";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;


   /* public static void addResultForTestCase(String testCseId, int status,
                                            String error) throws IOException, APIException {
        String testRunId = TEST_RUN_ID;
        APIClient client = new APIClient(RAILS_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "Test Executed - status updates automatically");
        client.sendPost("add_result_for_case/" + testRunId+ "/" + testCseId + "", data);

    }*/
}
