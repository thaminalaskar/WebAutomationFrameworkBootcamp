package com.facebook.loginpagetest;

import com.facebook.pages.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LoginTest extends TestBase {
    private static final Logger logger = Logger.getLogger(com.facebook.loginpagetest.LoginTest.class);
    LoginPage loginPage;

    //Positive Test
    @Test(priority = 1)
    public void userCanVerifyLogin(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterEmailInField();
        loginPage.enterPasswordInField();
        loginPage.clickOnLoginButton();
        ExtentTestManager.log("User click on login button",logger);
        String expectedTitle = loginPage.getTitleOfLoginPage();
        String actualTitle= "Facebook - Log In or Sign Up";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User get title as expected",logger);
    }


    @Test(priority = 2)
    public void userCanVerifyLoginButton(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        Assert.assertTrue(loginPage.loginButtonVerify());
        ExtentTestManager.log("in log in page login button is present",logger);
    }

    @Test(priority = 3)
    public void userCanVerifyUserName(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterEmailInField();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessageTest());
        ExtentTestManager.log("User enter only email field and user got error message as expected",logger);
    }

    @Test(priority = 4)
    public void userCanVerifyPassword(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.enterPasswordInField();
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.errorMessageTest());
        ExtentTestManager.log("User enter only email field and user got error message as expected",logger);
    }


     @Test(priority = 5)
        public void userCanVerifyLogo(){
         loginPage = PageFactory.initElements(driver,LoginPage.class);
          Assert.assertTrue(loginPage.facebookLogo());
          ExtentTestManager.log("FaceBook Logo present in log in page",logger);
     }

    @Test(priority = 6)
    public void userCanClickOnForgotLink(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnForgotButton();
        Assert.assertTrue(loginPage.findYourAccountText());
        ExtentTestManager.log("User get expected Text",logger);
    }




}
