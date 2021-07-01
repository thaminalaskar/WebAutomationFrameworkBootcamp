package com.amazon.footertest;

import com.amazon.footerpage.FooterPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class FooterPageTest extends TestBase {
    private static final Logger logger = Logger.getLogger(FooterPageTest.class);
    FooterPage fotterPage;


    @Test(priority = 1)
    public void validateUserCanClickCareerLinkTest(){
           fotterPage = PageFactory.initElements(driver, FooterPage.class);
           fotterPage.careersLink();
           ExtentTestManager.log("click CareerLink properly",logger);
    }

    @Test(priority = 2)
    public void validateCareerLinkTitleTest(){
        fotterPage = PageFactory.initElements(driver, FooterPage.class);
        String expected = fotterPage.careersLinkText();
        String actual = "Amazon.jobs: Help us build Earth’s most customer-centric company.";
        Assert.assertEquals(expected,actual,"Title did not Match properly");
        ExtentTestManager.log("Title Find as Expected",logger);
    }
    @Test(priority = 2)
    public void validateBlogLinkTitleTest(){
        fotterPage = PageFactory.initElements(driver, FooterPage.class);
        String expected = fotterPage.blogLinkTitle();
        String actual = "About Amazon";
        Assert.assertEquals(expected,actual,"Title did not Match properly");
        ExtentTestManager.log("Title Find as Expected",logger);
    }







}
