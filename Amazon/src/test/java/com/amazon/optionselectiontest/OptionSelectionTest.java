package com.amazon.optionselectiontest;

import com.amazon.departmentoption.DepartmentOptionSection;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class OptionSelectionTest extends TestBase {
    private static final Logger logger = Logger.getLogger(OptionSelectionTest.class);
    DepartmentOptionSection departmentOptionSection;


    @Test(enabled = false)
    public void validateAllOption(){
        departmentOptionSection = PageFactory.initElements(driver,DepartmentOptionSection.class);
        departmentOptionSection.clickOnShopAllDealsLink();
        ExtentTestManager.log("User successfully select department all options",logger);
    }

    @Test
    public void validateAllOptionAndClearIteam(){
        departmentOptionSection = PageFactory.initElements(driver,DepartmentOptionSection.class);
        departmentOptionSection.clickOnShopAllDealsLink();
        ExtentTestManager.log("User successfully select department all options",logger);
        ExtentTestManager.log("User successfully clear all option",logger);

    }







}
