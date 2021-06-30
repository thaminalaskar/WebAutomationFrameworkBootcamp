package com.amazon.searchitemtest;


import com.amazon.dataprovider.DataProviderTest;
import com.amazon.searchitem.SearchPage;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class SearchTest extends TestBase {

    private static final Logger logger = Logger.getLogger(SearchTest.class);

    @Test(dataProviderClass = DataProviderTest.class,dataProvider = "getDataForSearchTest")
    public void validateUserSearchAnItem(String productName){
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
         searchPage.typeOnSearchBar(productName);
         ExtentTestManager.log(productName+" type on search bar",logger);
         searchPage.clickOnSearchButton();
         ExtentTestManager.log("Clicked on search bar",logger);
         String expectedTitle = searchPage.searchPageTitle();
         String actualTitle = "Amazon.com : Laptop";
         Assert.assertEquals(expectedTitle,actualTitle,"Title did not match");
         ExtentTestManager.log("User get "+productName+" in search page",logger);
    }


}
