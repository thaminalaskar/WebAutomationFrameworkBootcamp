package com.cigna.dentalHealthPage;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DentalHealthPage extends TestBase {

      @FindBy(xpath = "//a[@id='individuals-families-level-one-link']")
      WebElement individualsAndFamily;

      @FindBy(css = "#health-wellness-tab")
      WebElement healthAndWellness;

      @FindBy(xpath = "//a[contains(text(),'Dental Health')]")
      WebElement healthpage ;

      @FindBy(xpath = "//a[contains(text(),'View Dental Plans')]")
      WebElement viewDentalPlan;

      @FindBy(xpath = "(//a[@class='btn btn-primary link-external'])[2]")
      WebElement getQuote ;



//      @FindBy(xpath = "//input[@id='uxFieldZipCode']")
//      WebElement myHomeZipCode;

      By myHomeZipCode = By.xpath("//input[@id='uxFieldZipCode']");

      @FindBy(xpath = "//select[@id='uxFieldEffectiveDate']")
      WebElement coverageStartDate ;

      @FindBy(xpath = "//input[@id='uxFieldFirstName']")
      WebElement firstName ;
      @FindBy(xpath = "//input[@id='uxFieldLastName']")
      WebElement lastName ;

      @FindBy(xpath = "//select[@id='uxFieldPhoneType']")
      WebElement phone ;

      @FindBy(xpath = "//input[@id='uxFieldEmail']")
      WebElement email ;



  public void dentalHealthPage(String zip, String firstNames, String lastNames, String emails){
    hoverAndClick(driver,individualsAndFamily,healthAndWellness);
    healthpage.click();
    viewDentalPlan.click();
    windowHalfPageScroll();
    getQuote.click();
    handleNewTab(driver);
    waitForElementToBeLocated(myHomeZipCode,10).sendKeys(zip);
    sleepFor(2);
    selectValueFromDropDown(coverageStartDate,"8/1/2021");
    firstName.sendKeys(firstNames);
    lastName.sendKeys(lastNames);
    selectValueFromDropDown(phone,"Home");
    sleepFor(3);
  }

  public String titleOfDentalHealthPage(){
     return getTitle();
  }








}
