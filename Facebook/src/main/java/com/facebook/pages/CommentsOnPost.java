package com.facebook.pages;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentsOnPost extends TestBase {
    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "input#pass")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    @FindBy(xpath = "(//div[@class='gtad4xkn']/div/span)[1]")
    private WebElement commentsSection;
    @FindBy(xpath = "(//div[@class='_1mf _1mj'])[1]")
    private WebElement commentsFields;

    public void loginHomePage(String emails, String pass){
        emailField.sendKeys(emails);
        passwordField.sendKeys(pass);
        loginButton.click();
        commentsSection.click();
        sleepFor(3);
        commentsFields.sendKeys("Allah vorosha");
        keyBoardEnter();
    }

    public String titleOfHomePage(){
        return getTitle();
    }


}
