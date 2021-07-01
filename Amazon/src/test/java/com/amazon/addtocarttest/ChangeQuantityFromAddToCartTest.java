package com.amazon.addtocarttest;

import com.amazon.addtocartpage.ChangeQuantityFromAddToCart;
import common.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ChangeQuantityFromAddToCartTest extends TestBase {
    private static final Logger logger = Logger.getLogger(ChangeQuantityFromAddToCartTest.class);
     private ChangeQuantityFromAddToCart changeQuantityFromAddToCart;

    @Test
    public void validateChangeQuantityTest(){
        changeQuantityFromAddToCart = PageFactory.initElements(driver,ChangeQuantityFromAddToCart.class);
        changeQuantityFromAddToCart.ClickOnCartButton();
        changeQuantityFromAddToCart.clickOnQuantityButton();
        changeQuantityFromAddToCart.clickOnQuantityNumber();


    }





}
