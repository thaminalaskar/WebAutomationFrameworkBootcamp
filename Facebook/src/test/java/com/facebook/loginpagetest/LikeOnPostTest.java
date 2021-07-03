package com.facebook.loginpagetest;

import com.facebook.pages.LikeAnyPost;
import com.facebook.pages.LoginPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class LikeOnPostTest extends TestBase {
    private static final Logger logger = Logger.getLogger(com.facebook.loginpagetest.LikeOnPostTest.class);
    LoginPage loginPage;
    LikeAnyPost likeAnyPost;

    @Test
    public void likeOnPostTest(){
         likeAnyPost = PageFactory.initElements(driver,LikeAnyPost.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.emailField();
        ExtentTestManager.log("User enter email",logger);
        loginPage.passwordField();
        ExtentTestManager.log("User enter pass",logger);
        loginPage.loginButton();
        ExtentTestManager.log("User click loginButton",logger);
        sleepFor(5);
        likeAnyPost.likeOnPost();
        ExtentTestManager.log("User like on post",logger);
        Assert.assertTrue( likeAnyPost.likeOnPost());
        ExtentTestManager.log("User succesfully like on post",logger);
    }





}
