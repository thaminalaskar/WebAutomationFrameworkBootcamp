package com.amazon.MenuOptionSelection;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuOption extends TestBase {

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    private WebElement allOptions ;

    @FindBy(xpath = "//option[contains(text(),'Audible Books & Originals')]")
    private WebElement audioBook;

    public void validateMenuOptions(){
        selectByVisibleText(allOptions,"All Departments");
        sleepFor(1);
        selectByVisibleText(allOptions,"Audible Books & Originals");
        sleepFor(1);
        selectByVisibleText(allOptions,"Alexa Skills");
        sleepFor(1);
        selectByVisibleText(allOptions,"Amazon Devices");
        sleepFor(1);
        selectByVisibleText(allOptions,"Amazon Pharmacy");
        sleepFor(1);
        selectByVisibleText(allOptions,"Amazon Warehouse");
    }

    public boolean optionsDisplay(){
        return audioBook.isDisplayed();
    }
}
