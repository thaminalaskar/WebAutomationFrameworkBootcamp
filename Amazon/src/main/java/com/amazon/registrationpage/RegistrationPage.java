package com.amazon.registrationpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[9]/div[2]/a[1]/span[1]")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAmazonAccount ;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement reEnterPass;

    @FindBy(xpath = "//h1[contains(text(),'Create account')]")
    private WebElement createAccountText ;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement createAccount ;

    @FindBy(xpath = "//div[contains(text(),'Enter your name')]")
    private WebElement nameText ;
    @FindBy(xpath = "//div[contains(text(),'Enter your email')]")
    private WebElement emailText ;
    @FindBy(xpath = "//div[contains(text(),'Enter your password')]")
    private WebElement passwordText ;



    public void clickOnSignInButton(){
        signInButton.click();
    }
    public void clickOnAmazonAccountlink(){
        createAmazonAccount.click();
    }

    public void UserName(String names){
        name.sendKeys(names);
    }
    public void UserEmail(String emails){
        email.sendKeys(emails);
    }
    public void UserPass(String pass){
        password.sendKeys(pass);
    }
    public void UserReEnterPass(String rePass){
        reEnterPass.sendKeys(rePass);
    }

    public String createAccountText(){
       return createAccountText.getText();
    }

    public void clickOnAccountButton(){
        createAccount.click();
    }

    public String errorMessageForName(){
       return nameText.getText();
    }
    public String errorMessageForEmail(){
        return emailText.getText();
    }
    public String errorMessageForPassword(){
        return passwordText.getText();
    }





}
