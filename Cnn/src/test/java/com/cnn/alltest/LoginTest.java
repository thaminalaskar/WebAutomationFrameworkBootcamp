package com.cnn.alltest;
import com.cnn.pages.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LoginTest extends TestBase {
    private static final Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    public void verifyLoginTest(){
        LoginPage loginPage =PageFactory.initElements(driver,LoginPage.class);
        loginPage.VerifyLoginPage();
        ExtentTestManager.log("User successfully log in account",logger);
    }



}
