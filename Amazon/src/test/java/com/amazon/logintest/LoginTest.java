package com.amazon.logintest;

import com.amazon.loginpage.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LoginTest extends TestBase {
    private static final Logger logger = Logger.getLogger(LoginTest.class);
    LoginPage loginPage;
    @Test
    public void validateLogInPage(){
         loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnLoginButton();
        ExtentTestManager.log("User click sign in button ",logger);
        Assert.assertTrue(loginPage.checkLoginImage(),"Image not present");
        ExtentTestManager.log("User find Sign in image ",logger);
    }
}
