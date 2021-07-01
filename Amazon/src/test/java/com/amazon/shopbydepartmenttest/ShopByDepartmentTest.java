package com.amazon.shopbydepartmenttest;


import com.amazon.shopbydepartment.ShopByDepartment;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ExtentTestManager;

public class ShopByDepartmentTest extends TestBase {

    private static final Logger logger = Logger.getLogger(ShopByDepartmentTest.class);
    ShopByDepartment shopByDepartment;

    @Test(enabled = false)
    public void tVDepartmentTest(){
      shopByDepartment = PageFactory.initElements(driver,ShopByDepartment.class);
        shopByDepartment.allOptionButtonClick();
        shopByDepartment.electricButtonClick();
        shopByDepartment.tvAndVideoButtonClick();
        Assert.assertTrue(shopByDepartment.handPickUPImage(),"Image not present");
        ExtentTestManager.log("User find as expected page",logger);
    }


    @Test
    public void validateAddToCartTest(){
         shopByDepartment = PageFactory.initElements(driver,ShopByDepartment.class);
         shopByDepartment.addToCardTV();
         String expectedTitle = getTitle();
         String actualTitle ="Amazon Sign-In";
         Assert.assertEquals(expectedTitle,actualTitle,"Title not match");
         ExtentTestManager.log("User successFully add to cart ",logger);
         ExtentTestManager.log("User successFully get Title ",logger);
    }
















}
