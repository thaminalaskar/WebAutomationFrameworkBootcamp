package com.amazon.footerpage;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends TestBase {

    @FindBy(linkText = "Careers")
    private WebElement careers ;

    @FindBy(linkText = "Blog")
    private WebElement blog ;

    public void careersLink(){
        windowsFullPageScrollDown();
        careers.click();
    }

    public String careersLinkText(){
        windowsFullPageScrollDown();
        careersLink();
        return driver.getTitle();
    }

    public void blogLink(){
        windowsFullPageScrollDown();
        blog.click();
    }
    public String blogLinkTitle(){
         windowsFullPageScrollDown();
         blogLink();
         return driver.getTitle();
    }





}
