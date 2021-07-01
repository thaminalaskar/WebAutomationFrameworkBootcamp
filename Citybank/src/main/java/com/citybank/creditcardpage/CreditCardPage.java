package com.citybank.creditcardpage;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardPage extends TestBase {
    @FindBy(id = "navcreditCardmainAnchor0")
    WebElement creditCards;
    @FindBy(xpath = "//a[@id='Small Business Credit CardschildLink6']")
    WebElement smallBusinessCreditCard;
    @FindBy(xpath = "//div[@id='ca-DD-mppTitle']/h1")
    WebElement text ;
    @FindBy(xpath = "//a[@id='Balance Transfer Credit CardschildLink1']")
    WebElement balanceTransferCreditCard ;
    @FindBy(xpath = "//a[@id='0% Intro APR Credit CardschildLink2']")
    WebElement zeroPercentAprCreditCard;
    @FindBy(xpath = "//a[@id='Rewards Credit CardschildLink3']")
    WebElement rewardCreditCard ;
    @FindBy(xpath = "//a[@id='Cash Back Credit CardschildLink4']")
    WebElement cashBackCreditCard;
    @FindBy(xpath = "//a[@id='Travel Credit CardschildLink5']")
    WebElement travelCreditCard ;









   public void verifySmallBusinessCreditCard(){
       hoverAndClick(driver,creditCards,smallBusinessCreditCard);
   }
     public boolean verifyText(){
      return text.isDisplayed();
   }
     public String verifyBalanceTransferCreditCard(){
     hoverAndClick(driver,creditCards,balanceTransferCreditCard);
     return getTitle();
    }

    public String verifyZeroPercentAprCreditCard(){
        hoverAndClick(driver,creditCards,zeroPercentAprCreditCard);
        return getTitle();
    }
    public String verifyRewardCreditCard(){
        hoverAndClick(driver,creditCards,rewardCreditCard);
        return getTitle();
    }
    public String verifyCashBackCreditCard(){
        hoverAndClick(driver,creditCards,cashBackCreditCard);
        return getTitle();
    }
    public String verifyTravelCreditCard(){
        hoverAndClick(driver,creditCards,travelCreditCard);
        return getTitle();
    }

}
