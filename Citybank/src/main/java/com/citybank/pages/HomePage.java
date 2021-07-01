package com.citybank.pages;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends TestBase {

    @FindBy(xpath = "//citi-header/div[1]/div[1]/citi-banner2[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement image ;

    public String titleOfHomePage(){
        return getTitle();
    }
    public boolean imageOnDisplay(){
       return image.isDisplayed();
    }

}
