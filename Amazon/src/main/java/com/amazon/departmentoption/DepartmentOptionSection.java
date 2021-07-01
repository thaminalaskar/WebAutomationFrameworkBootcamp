package com.amazon.departmentoption;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepartmentOptionSection extends TestBase {

    By shopAllDeals = By.xpath("(//span[@class=\"a-list-item\"])[1]");
    By amazonDevice = By.xpath("(//span[@aria-label='Departments filter']/div/div)[1]");
    By art_Craft_Sewing = By.xpath("(//span[@aria-label='Departments filter']/div/div)[2]");
    By automative_motocycle = By.xpath("(//span[@aria-label='Departments filter']/div/div)[3]");
    By baby = By.xpath("(//span[@aria-label='Departments filter']/div/div)[4]");
    By babyClothing = By.xpath("(//span[@aria-label='Departments filter']/div/div)[5]");

    @FindBy(xpath = "//a[contains(text(),'Clear')]")
     private WebElement clearAlliteam ;

  public void clickOnShopAllDealsLink(){
      windowHalfPageScroll();
      waitForElementToBeLocated(shopAllDeals,10).click();
      windowTwoThirdPageScroll();
      waitForElementToBeLocated(amazonDevice,1).click();
      waitForElementToBeLocated(art_Craft_Sewing,1).click();
      waitForElementToBeLocated(automative_motocycle,1).click();
      waitForElementToBeLocated(baby,1).click();
      waitForElementToBeLocated(babyClothing,1).click();
      sleepFor(2);
      clearAlliteam.click();
  }









}
