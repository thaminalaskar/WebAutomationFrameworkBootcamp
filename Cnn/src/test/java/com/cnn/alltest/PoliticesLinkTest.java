package com.cnn.alltest;

import com.cnn.pages.PoliticesPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class PoliticesLinkTest extends TestBase {

    private static final Logger logger = Logger.getLogger(PoliticesLinkTest.class);

    @Test
    public void readPoliticsLinkNewsTest(){
        PoliticesPage politicesPage = PageFactory.initElements(driver,PoliticesPage.class);
        politicesPage.verifyPoliticesLink();
        ExtentTestManager.log("Read news politics page",logger);
    }




}
