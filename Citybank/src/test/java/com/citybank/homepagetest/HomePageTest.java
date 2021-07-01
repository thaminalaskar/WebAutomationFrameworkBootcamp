package com.citybank.homepagetest;

import com.citybank.pages.HomePage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class HomePageTest extends TestBase {
    private static final Logger logger = Logger.getLogger(HomePageTest.class);
    HomePage homePage ;


    @Test
    public void validateTitleTest(){
        homePage = PageFactory.initElements(driver,HomePage.class);
       String expectedTitle = homePage.titleOfHomePage();
       String actualTitle = "Online Banking, Mortgages, Personal Loans, Investing | Citi.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
    }

    @Test
    public void validateImageTest(){
        Assert.assertTrue(homePage.imageOnDisplay(),"Image not display");
        ExtentTestManager.log("Image display properly",logger);
    }


}
