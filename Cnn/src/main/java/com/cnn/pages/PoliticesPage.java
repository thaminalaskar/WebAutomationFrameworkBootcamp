package com.cnn.pages;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoliticesPage extends TestBase {

    @FindBy(xpath = "(//a[@name='politics'])[1]")
    WebElement politicesLink;

    @FindBy(xpath = "(//span[@class='cd__headline-text vid-left-enabled'])[5]")
    WebElement news;

    public void verifyPoliticesLink(){
        politicesLink.click();
        System.out.println(news.getText());
    }










}
