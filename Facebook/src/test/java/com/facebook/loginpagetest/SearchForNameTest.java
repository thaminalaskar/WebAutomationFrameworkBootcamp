package com.facebook.loginpagetest;

import com.facebook.pages.SearchForName;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class SearchForNameTest extends TestBase {
    private static final Logger logger = Logger.getLogger(LoginTest.class);
    SearchForName searchForName;
    @Test
    public void logInAndSearchForNameTest(){
         searchForName = PageFactory.initElements(driver,SearchForName.class);
         searchForName.loginHomePage(prop.getProperty("username"),prop.getProperty("password"));
         Assert.assertTrue(searchForName.personName());
         ExtentTestManager.log("User got person name on people page",logger);
         ExtentTestManager.log("User got expected person in search page",logger);
    }


}
