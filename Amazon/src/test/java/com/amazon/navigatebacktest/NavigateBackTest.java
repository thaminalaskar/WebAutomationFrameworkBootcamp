package com.amazon.navigatebacktest;

import com.amazon.navigation.NavigationCheck;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class NavigateBackTest extends TestBase {

    private static final Logger logger = Logger.getLogger(NavigateBackTest.class);
    NavigationCheck navigationCheck;

    @Test
    public void validateUserCanNavigateBack(){
          navigationCheck = PageFactory.initElements(driver,NavigationCheck.class);
        String expected = navigationCheck.getTitleOfAmazonHomePage();
        String actual ="Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(expected,actual,"title did not match");
        ExtentTestManager.log("User got as expected title",logger);
        String expectedTitle = navigationCheck.addToCartBook();
        String actualTitle = "Amazon.com Shopping Cart";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User got as expected shopping cart title",logger);
        sleepFor(2);
        navigationCheck.navigationBack();
        sleepFor(2);
        navigationCheck.navigationBack();
        sleepFor(2);
        navigationCheck.navigationBack();
        sleepFor(2);
        navigationCheck.navigationBack();
        ExtentTestManager.log("User succesfully come back home page",logger);
    }













}
