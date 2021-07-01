package com.citybank.creditcardsearch;

import com.citybank.creditcardtest.CreditCardTest;
import com.citybank.searchPage.SearchForCreditCard;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditCardSearchTest extends TestBase {
    private static final Logger logger = Logger.getLogger(CreditCardTest.class);

    @Test
    public void searchForCreditCardTest(){
        SearchForCreditCard searchForCreditCard = PageFactory.initElements(driver,SearchForCreditCard.class);
        searchForCreditCard.verifyAnyCreditCardInSearchBox();
        String expectedText= searchForCreditCard.searchResultTText();
        String actualText = "travel credit card";
        Assert.assertEquals(expectedText,actualText,"search not match");
    }











}
