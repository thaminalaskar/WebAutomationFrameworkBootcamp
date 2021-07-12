package com.citibank.creditcardsearch;

import com.citibank.creditcardtest.CreditCardTest;
import com.citibank.searchPage.SearchForCreditCard;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreditCardSearchTest extends TestBase {
    private static final Logger logger = Logger.getLogger(CreditCardTest.class);

    @Test
    public void validateUserCanSearchForCreditCard(){
        SearchForCreditCard searchForCreditCard = PageFactory.initElements(driver,SearchForCreditCard.class);
        searchForCreditCard.verifyAnyCreditCardInSearchBox();
        String expectedText= searchForCreditCard.getSearchResultTText();
        String actualText = "travel credit card";
        Assert.assertEquals(expectedText,actualText,"search not match");
    }











}
