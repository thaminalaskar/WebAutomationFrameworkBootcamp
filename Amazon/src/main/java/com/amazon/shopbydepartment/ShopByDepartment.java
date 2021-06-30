package com.amazon.shopbydepartment;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopByDepartment extends TestBase {
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement allOption ;

    @FindBy(xpath = "//div[contains(text(),'Electronics')]")
    private WebElement electronics ;

    @FindBy(xpath = "(//ul[@class='hmenu hmenu-visible hmenu-translateX']/li)[3]")
    private WebElement tVAndVideo ;

    @FindBy(xpath = "(//div[@class='bxc-grid__image   bxc-grid__image--light'])[1]")
    private WebElement handPickUPImage ;

    @FindBy(xpath = "(//div[@class='bxc-grid__image   bxc-grid__image--light'])[2]")
    private WebElement budget ;

    @FindBy(xpath = "//div[contains(@class,'a-container')]//div[2]//div[1]//div[1]//div[1]//p[1]//a[1]//img[1]")
    private WebElement tclTv;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton ;

    @FindBy(xpath = "//a[@id='hlb-ptc-btn-native']")
    private WebElement processToCheckOutButton ;

    @FindBy(xpath = "(//input[@class='a-button-input'])[2]")
    private  WebElement noThanksButton ;


    public void allOptionButtonClick(){
        allOption.click();
    }

    public void electricButtonClick(){
        sleepFor(1);
        windowsFullPageScrollDown();
        electronics.click();
    }

    public void tvAndVideoButtonClick(){
        sleepFor(1);
        tVAndVideo.click();

    }

    public boolean handPickUPImage(){
        return handPickUPImage.isDisplayed();
    }


    public void addToCardTV(){
        allOptionButtonClick();
        electricButtonClick();
        tvAndVideoButtonClick();
        budget.click();
        tclTv.click();
        addToCartButton.click();
        noThanksButton.click();
        processToCheckOutButton.click();
    }
}
