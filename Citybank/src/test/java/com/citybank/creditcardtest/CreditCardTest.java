package com.citybank.creditcardtest;

import com.citybank.creditcardpage.CreditCardPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class CreditCardTest extends TestBase {
    private static final Logger logger = Logger.getLogger(CreditCardTest.class);
    CreditCardPage creditCardPage;
    @Test
    public void smallBusinessCreditCardTest(){
         creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
        sleepFor(3);
        creditCardPage.verifySmallBusinessCreditCard();
        Assert.assertTrue(creditCardPage.verifyText());
        ExtentTestManager.log("User in credit card page",logger);
    }

    @Test
    public void BalanceTransferCreditCardTest(){
         creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
         sleepFor(3);
         creditCardPage.verifyBalanceTransferCreditCard();
         String expectedTitle = creditCardPage.verifyBalanceTransferCreditCard();
         String actualTitle ="Best Balance Transfer Credit Cards - Citi.com";
         Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
         ExtentTestManager.log("User in balance transfer credit card page",logger);
    }
    @Test
    public void  verifyZeroPercentAprCreditCardTest(){
        creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
        sleepFor(3);
        creditCardPage.verifyZeroPercentAprCreditCard();
        String expectedTitle = creditCardPage.verifyBalanceTransferCreditCard();
        String actualTitle ="0% Intro APR  Credit Cards - Citi.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User ZeroPercentAprCreditCard page",logger);
    }
    @Test
    public void verifyRewardCreditCardTest(){
        creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
        sleepFor(3);
        creditCardPage.verifyRewardCreditCard();
        String expectedTitle = creditCardPage.verifyBalanceTransferCreditCard();
        String actualTitle ="Best Rewards Credit Cards - Citi.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User in reward  credit card page",logger);
    }

    @Test
    public void verifyCashBackCreditCardTest(){
        creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
        sleepFor(3);
        creditCardPage.verifyCashBackCreditCard();
        String expectedTitle = creditCardPage.verifyBalanceTransferCreditCard();
        String actualTitle ="Cash Back Credit Cards - Citi.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User in cash back credit card page",logger);
    }
    @Test
    public void verifyTravelCreditCardTest(){
        creditCardPage = PageFactory.initElements(driver,CreditCardPage.class);
        sleepFor(3);
        creditCardPage.verifyTravelCreditCard();
        String expectedTitle = creditCardPage.verifyBalanceTransferCreditCard();
        String actualTitle ="Best Travel Rewards Credit Cards - Citi.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
        ExtentTestManager.log("User in travel credit credit card page",logger);
    }





}
