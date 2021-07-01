package com.citybank.loginpage;

import common.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase {
    @FindBy(css = "input#username")
    private WebElement userId;
    @FindBy(css = "input#password")
    private WebElement password ;
    @FindBy(css = "button#signInBtn")
    private WebElement signOnButton ;

    public void verifyUserId(String id){
        userId.sendKeys(id);
    }
    public void verifyPassword(String password){
        userId.sendKeys(password);
    }
    public void verifySignOnButton(){
       signOnButton.click();
    }

   public String titleOfHomePage(){
      return getTitle();
   }






}
