package com.sip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInputBox;

    @FindBy(name = "password")
    private WebElement passwordInputBox;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public void enterCreds(String un, String pwd){
        userNameInputBox.sendKeys(un);
        passwordInputBox.sendKeys(pwd);
    }

    public void clickSubmit(){
        loginButton.click();
    }
}
