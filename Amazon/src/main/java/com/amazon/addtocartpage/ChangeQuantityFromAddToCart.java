package com.amazon.addtocartpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeQuantityFromAddToCart {

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cart ;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement clickOnQtcButton;


    @FindBy(xpath = "//a[@id='dropdown7_3']")
    private WebElement quantityNumber;

    public void ClickOnCartButton(){
        cart.click();
    }

    public void clickOnQuantityButton(){
        clickOnQtcButton.click();
    }

    public void clickOnQuantityNumber(){
        quantityNumber.click();
    }











}
