package com.citybank.searchPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchForCreditCard {

    @FindBy(xpath = "//button[@id='personetics-citi-menu']")
    private WebElement clickOnSearchBoxButton  ;

    @FindBy(xpath = "//input[@id='autocomplete-search']")
    WebElement searchInbox ;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement finalSearchBox ;

    @FindBy(xpath = "/b[contains(text(),'travel credit card')]")
    WebElement travelCreditCardInformation;


   public void verifyAnyCreditCardInSearchBox(){
       clickOnSearchBoxButton.click();
       searchInbox.sendKeys("Travel credit card");
       finalSearchBox.click();
   }

   public String searchResultTText(){
      return travelCreditCardInformation.getText();
   }










}
