package com.sip.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsPage {
    public AllProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name ")
    private List<WebElement> listOfProducts;

    public int getNumberOfProducts(){
        return listOfProducts.size();
    }

}
