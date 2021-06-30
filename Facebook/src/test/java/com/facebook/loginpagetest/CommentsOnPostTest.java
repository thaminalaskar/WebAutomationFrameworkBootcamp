package com.facebook.loginpagetest;

import com.facebook.pages.CommentsOnPost;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class CommentsOnPostTest extends TestBase {
    private static final Logger logger = Logger.getLogger(CommentsOnPostTest.class);
    CommentsOnPost commentsOnPost;

    @Test
    public void commentsOnPostTest(){
        commentsOnPost = PageFactory.initElements(driver, CommentsOnPost.class);
        commentsOnPost.loginHomePage(prop.getProperty("username"),prop.getProperty("password"));
        String expected = commentsOnPost.titleOfHomePage();
        String actual = "Facebook";
        Assert.assertEquals(expected,actual,"Title did not match");
        ExtentTestManager.log("User write on comments",logger);
    }
}
