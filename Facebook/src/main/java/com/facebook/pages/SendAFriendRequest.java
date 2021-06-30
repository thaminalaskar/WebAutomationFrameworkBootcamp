package com.facebook.pages;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendAFriendRequest extends TestBase {
    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "input#pass")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    By searchBox = By.xpath("//input[@name='global_typeahead']");

    @FindBy(xpath = "//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5']")
    private WebElement searchButton ;

    @FindBy(xpath = "//div[@class='qu0x051f f10w8fjw jb3vyjys']//div//i[@class='hu5pjgll lzf7d6o1']")
    private WebElement friendRequestButton ;


    public void loginHomePage(String emails, String pass){
        emailField.sendKeys(emails);
        passwordField.sendKeys(pass);
        loginButton.click();
        waitForElementToBeLocated(searchBox,20).sendKeys("mr alom");
        searchButton.click();
        friendRequestButton.click();

    }
}
