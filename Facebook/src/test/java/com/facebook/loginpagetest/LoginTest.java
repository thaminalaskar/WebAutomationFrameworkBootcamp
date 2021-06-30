package com.facebook.loginpagetest;

import com.facebook.pages.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LoginTest extends TestBase {
    private static final Logger logger = Logger.getLogger(LoginTest.class);
    LoginPage loginPage;

    //Positive Test
    @Test(priority = 1)
    public void VerifyLoginTest(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.emailField();
        loginPage.passwordField();
        loginPage.loginButton();
        ExtentTestManager.log("User click on login button",logger);
        String expectedTitle = loginPage.titleOfLoginPage();
        String actualTitle= "Facebook - Log In or Sign Up";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User get title as expected",logger);
    }


    @Test(priority = 2)
    public void verifyOnlyLoginButtonTest(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        Assert.assertTrue(loginPage.loginButtonVerify());
        ExtentTestManager.log("in log in page login button is present",logger);
    }

    @Test(priority = 3)
    public void verifyUserNameTest(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.emailField();
        loginPage.loginButton();
        Assert.assertTrue(loginPage.errorMessageTest());
        ExtentTestManager.log("User enter only email field and user got error message as expected",logger);
    }

    @Test(priority = 4)
    public void verifyPasswordTest(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.passwordField();
        loginPage.loginButton();
        Assert.assertTrue(loginPage.errorMessageTest());
        ExtentTestManager.log("User enter only email field and user got error message as expected",logger);
    }


     @Test(priority = 5)
        public void verifyImageTest(){
         loginPage = PageFactory.initElements(driver,LoginPage.class);
          Assert.assertTrue(loginPage.facebookLogo());
          ExtentTestManager.log("FaceBook Logo present in log in page",logger);
     }

    @Test(priority = 6)
    public void forgotLinkTest(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.forgotButton();
        Assert.assertTrue(loginPage.findYourAccountText());
        ExtentTestManager.log("User get expected Text",logger);
    }




}
