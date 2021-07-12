package com.amazon.menuoptiontest;

import com.amazon.MenuOptionSelection.MenuOption;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class MenuOptionsTest extends TestBase {
    private static final Logger logger = Logger.getLogger(MenuOption.class);
    MenuOption menuOption;


    @Test(priority = 1,description = "verifying amazon option Test")
    public void validateUserCanSelectAllOptions(){
        menuOption = PageFactory.initElements(driver,MenuOption.class);
        menuOption.validateMenuOptions();
        ExtentTestManager.log("All option selected Successfully",logger);

    }
    @Test(priority = 2,description = "check audioBook link display",enabled = false)
    public void validateAllOptionsIsDisplayed(){
         menuOption = PageFactory.initElements(driver,MenuOption.class);
        Assert.assertTrue(  menuOption.optionsDisplay());
        ExtentTestManager.log("AudioBook display",logger);
    }






}
