package com.sip.steps;

import com.sip.Utilities.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class HomeSteps {
    Context context;

    public HomeSteps(){
        context = new Context();
    }

    @Given("User on login screen")
    public void user_on_login_screen() {
        System.out.println("user_on_login_screen");
    }
    @When("User enter login credentials")
    public void user_enter_login_credentials() {
        System.out.println("user_enter_login_credentials");
    }
    @When("User click on submit button")
    public void user_click_on_submit_button() {
        System.out.println("user_click_on_submit_button");
    }
    @Then("User verify products page displayed")
    public void user_verify_products_page_displayed() {
        System.out.println("user_verify_products_page_displayed");

        System.out.println("context value " + context.getContext("USERNAME"));
    }

    @When("User enter login credentials {string} and {string}")
    public void userEnterLoginCredentialsAnd(String username, String pwd) {
        System.out.println("un ::" + username);
        System.out.println("password :: " + pwd);
    }

    @When("User enter login data")
    public void userEnterLoginData(DataTable dataTable) {
        List<String> rowData = dataTable.row(0);

        String username = rowData.get(0);
        String password = rowData.get(1);
        System.out.println("Single row un :: " + username);
        System.out.println("Single row pwd :: " + password);
    }

    @When("User enter login data with row header")
    public void userEnterLoginDataWithRowHeader(DataTable dataTable) {
        List<Map<String, String >> fullData = dataTable.asMaps(String.class, String.class);
        String username = null;
        String pwd= null;
        for(Map<String, String> dataMap : fullData){
             username = dataMap.get("username");
             pwd = dataMap.get("password");
        }
        System.out.println("un ::" + username);
        System.out.println("password :: " + pwd);
        context.setContext("USERNAME", username);
    }
}
