package com.cigna.loginTest;

import com.cigna.dataprovidertest.DataProviderTest;
import com.cigna.loginPage.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LoginTest extends TestBase {
    private static final Logger logger = Logger.getLogger(LoginTest.class);
    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationTest",enabled = false)
    public void validateCredentialTest(String username, String password){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnLoginButton();
        ExtentTestManager.log("User in home page for click on login button",logger);
        handleNewTab(driver);
        ExtentTestManager.log("User Switch to another tab for log in",logger);
        loginPage.clickOnUserName(username);
        ExtentTestManager.log(username+" is enter in username field",logger);
        loginPage.clickOnPassword(password);
        ExtentTestManager.log(password+" is enter in password field",logger);
        loginPage.clickOnLogin();
        ExtentTestManager.log("User click on login button",logger);
        sleepFor(5);
        Assert.assertTrue(loginPage.erroMessage());
        ExtentTestManager.log("User get Error message for enter wrong credential",logger);
    }

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForRegistrationDataForInvalidteUserTest")
    public void validateCredentialErrorMessageTest(String username, String password){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnLoginButton();
        ExtentTestManager.log("User in home page for click on login button",logger);
        handleNewTab(driver);
        ExtentTestManager.log("User Switch to another tab for log in",logger);
        loginPage.clickOnUserName(username);
        ExtentTestManager.log(username+" void user name enter",logger);
        loginPage.clickOnPassword(password);
        ExtentTestManager.log(password+" void password enter",logger);
        loginPage.clickOnLogin();
        ExtentTestManager.log("User click on login button",logger);
        sleepFor(5);
        String expectedUsername = loginPage.errorMessageForUsername();
        String actual = "Username required.";
        Assert.assertEquals(expectedUsername,actual,"Error message not showing");
        String expectedPassword = loginPage.errorMessageForUsername();
        String actualpassword = "Username required.";
        Assert.assertEquals(expectedPassword,actualpassword,"Error message not showing");
    }





}
