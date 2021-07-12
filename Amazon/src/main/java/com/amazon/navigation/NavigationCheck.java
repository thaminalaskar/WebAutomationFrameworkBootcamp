package com.amazon.navigation;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationCheck extends TestBase {
    @FindBy(xpath = "(//div[@id='nav-xshop']/a)[6]")
    private WebElement books ;
    @FindBy(xpath = "//img[@alt='The Last Thing He Told Me: A Novel']")
    private WebElement bestSellerBook;
    @FindBy(css = "input#add-to-cart-button")
    private WebElement add_to_cart_Button;

    @FindBy(css = "a#hlb-view-cart-announce")
    WebElement cartButton;

     public String getTitleOfAmazonHomePage(){
         return getTitle();
     }
     public String addToCartBook(){
         books.click();
         windowTwoThirdPageScroll();
         bestSellerBook.click();
         add_to_cart_Button.click();
         cartButton.click();
         return  getTitle();
     }

     public void navigationBack(){
         navigateBack();
     }









}
