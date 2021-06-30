package com.facebook.pages;
import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase {

  @FindBy(css = "input#email")
  private WebElement emailField;

  @FindBy(css = "input#pass")
  private WebElement passwordField;

  @FindBy(xpath = "//button[@name='login']")
  private WebElement loginButton;

  @FindBy(xpath = "//img[@class='fb_logo _8ilh img']")
  private WebElement facebookLogo;

  @FindBy(xpath = "//div[@class='_9ay7']")
  private WebElement errorMessageForWrongCredential;


  @FindBy(xpath = "//div[@class='_97w3']/a")
  WebElement forgotButton;

  @FindBy(xpath = "//table[@class='_9nq3']/tbody/tr/td/div")
  WebElement findYourAccountText;


  public void emailField() {
    emailField.sendKeys("meah2401@gmail.com");
  }


  public void passwordField() {
    passwordField.sendKeys("Moto2020");
  }

  public void loginButton() {
    loginButton.click();
  }

  public boolean loginButtonVerify() {
    return loginButton.isDisplayed();
  }

  public boolean facebookLogo() {
    return facebookLogo.isDisplayed();
  }

  public String titleOfLoginPage() {
    return getTitle();
  }

  public boolean errorMessageTest() {
    return errorMessageForWrongCredential.isDisplayed();
  }

  public boolean findYourAccountText() {
   return findYourAccountText.isDisplayed();
  }

  public void forgotButton(){
    forgotButton.click();
  }

}
