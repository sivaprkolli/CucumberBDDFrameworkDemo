package com.sip.steps;

import com.sip.Automation.WebDriverfactory;
import com.sip.ObjectRepository.AllProductsPage;
import com.sip.ObjectRepository.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends WebDriverfactory {
    public LoginPage loginPage;
    public AllProductsPage allProductsPage;

    @Given("User on login page")
    public void user_on_loginpage() {
        loginPage = new LoginPage(driver);
    }

    @When("User enter {string} and {string}")
    public void user_enter_username_password(String un, String pwd) {
        loginPage.enterCreds(un,pwd);
    }

    @And("User click on submit")
    public void user_click_on_submit() {
        loginPage.clickSubmit();
    }

    @Then("User verify products page")
    public void user_verify_products_page() {
        allProductsPage = new AllProductsPage(driver);
        Assert.assertEquals(allProductsPage.getNumberOfProducts(), 7);
    }

    @When("User enter credentials in the input fields")
    public void user_enter_credentials_in_the_input_fields(DataTable dataTable) {
        List<String> data = dataTable.row(0);
        String username = data.get(0);
        String password = data.get(1);
        System.out.println(username + " ::: " + password);
    }

    @When("User enter credentials")
    public void user_enter_credentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> dataMap : data){
            String un = dataMap.get("username");
            String pwd = dataMap.get("password");
            System.out.println("username :: " + un + " :: " + "password :: " + pwd );
        }

    }
}
