package com.amazon.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

  @FindBy(xpath = "(//span[@class='nav-action-inner'])[2]")
  private WebElement loginButton;

  @FindBy(xpath = "//h1[normalize-space()='Sign-In']")
  private WebElement loginImage ;


  public void clickOnLoginButton(){
    loginButton.click();
  }

  public boolean checkLoginImage(){
    return loginImage.isDisplayed();
  }





}
