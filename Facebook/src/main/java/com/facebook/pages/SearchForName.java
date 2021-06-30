package com.facebook.pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchForName extends TestBase {
    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "input#pass")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

     By searchBox = By.xpath("//input[@name='global_typeahead']");

     @FindBy(xpath = "//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5']")
     private WebElement searchButton ;

     @FindBy(xpath = "(//span[@class='nc684nl6'])[1]")
     WebElement personName;

    public void loginHomePage(String emails, String pass){
        emailField.sendKeys(emails);
        passwordField.sendKeys(pass);
        loginButton.click();
        waitForElementToBeLocated(searchBox,20).sendKeys("mr alom");
        searchButton.click();
    }

    public boolean personName(){
       return personName.isDisplayed();
    }



}
